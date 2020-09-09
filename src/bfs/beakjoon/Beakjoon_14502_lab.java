package bfs.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * 220ms
 *
 */
public class Beakjoon_14502_lab {

	static int[][] map, copiedMap;
	static boolean[][] isVisited;
	private static ArrayList<int[]> virusArr;
	static int ans = 0, blankNum = 0, safetyZoneSize, N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다
		map = new int[N][M];
		copiedMap = new int[N][M];
		isVisited = new boolean[N][M];
		virusArr = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					blankNum++;
				} else if (map[i][j] == 2) {
					virusArr.add(new int[] { i, j });
				}
			}
		}

		solution();
		System.out.println(ans);

	} // end of main

	/** 벽세우기 -> 맵 복사 -> 바이러스 퍼트리고 -> 안전영역 갯수 새고 -> 안전영역 갯수 갱신 */
	private static void solution() {
		for (int row1 = 0; row1 < N; row1++) {
			for (int col1 = 0; col1 < M; col1++) {
				if (map[row1][col1] == 0) { // 첫 번째 벽이 설치가능한 경우
					map[row1][col1] = 1;

					for (int row2 = row1; row2 < N; row2++) {
						for (int col2 = 0; col2 < M; col2++) {
							if (row2 == row1 && col2 <= col1) { // 이미 방문한 자리는 continue
								continue;
							}
							if (map[row2][col2] == 0) { // 두 번째 벽이 설치가능한 경우
								map[row2][col2] = 1;

								for (int row3 = row2; row3 < N; row3++) {
									for (int col3 = 0; col3 < M; col3++) {
										if (row3 == row2 && col3 <= col2) { // 이미 방문한 자리는 continue
											continue;
										}
										if (map[row3][col3] == 0) { // 세 번째 벽이 설치가능한 경우
											map[row3][col3] = 1;

											/** 자원 리셋 */
											mapCopy(); // 맵복사
											safetyZoneSize = blankNum - 3; // 안전영역 초기화
											visitedReset();

											/** 바이러스 퍼트리기 */
											for (int[] v : virusArr) {
												dfs(v[0], v[1]);
											}

											if (safetyZoneSize > ans)
												ans = safetyZoneSize;
											map[row3][col3] = 0;
										}
									}
								}

								map[row2][col2] = 0;
							}
						}
					}

					map[row1][col1] = 0;
				}
			}
		}
	}

	private static void visitedReset() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				isVisited[i][j] = false;
			}
		}
	}

	private static void mapCopy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copiedMap[i][j] = map[i][j];
			}
		}
	}

	// 바이러스 퍼뜨리기
	static int[] dr = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dc = { 0, 0, -1, 1 }; // 상 하 좌 우

	public static void dfs(int r, int c) {
		if (safetyZoneSize == 0)
			return;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (0 <= nr && nr < N && 0 <= nc && nc < M && !isVisited[nr][nc] && copiedMap[nr][nc] == 0) {
				copiedMap[nr][nc] = 2;
				safetyZoneSize--;
				isVisited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
	}

}
