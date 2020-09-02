package bfs.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 미세먼지 안녕
public class Beakjoon_17144 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()); // 6 ≤ R, C ≤ 50
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken()); // 1 ≤ T ≤ 1,000 (초)

		int[][] map = new int[R][C];
		List<int[]> cleaner = new ArrayList<int[]>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					cleaner.add(new int[] { i, j });
				}
			}
		}

		while (T > 0) {
			// 1. 확산
			int[] dr = { -1, 1, 0, 0 }; // 상하좌우
			int[] dc = { 0, 0, -1, 1 };
			int[][] plus = new int[R][C]; // 확산이 겹칠 경우 더해야 할 값을 저장하는 배열
			for (int i = 0; i < R; i++) { // 1초의 확산이 끝나면 plus와 기존 미세먼지 합치는 작업 수행
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 0) {
						int after = map[i][j] / 5; // 확산 양
						int cnt = 0; // 확산 개수
						for (int d = 0; d < dc.length; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
								cnt++; // 확산 했으므로 플러스
								plus[nr][nc] += after;
							}
						}
						map[i][j] -= after * cnt; // 확산 후 미세먼지의 양 변화
					}
				}
			}
			for (int i = 0; i < R; i++) { // 1초의 확산이 끝나면 plus와 기존 미세먼지 합치는 작업 수행
				for (int j = 0; j < C; j++) {
					map[i][j] += plus[i][j];
				}
			}

			// 2. 공기청정기 가동
			// 2 - 1 청소기 1 가동
			int[] c1 = cleaner.get(0);
			int[] c2 = cleaner.get(1);
			// 아래
			for (int i = c1[0] - 1; i > 0; i--) {
				map[i][0] = map[i - 1][0];
			}
			// 왼쪽
			for (int j = 0; j < C - 1; j++) {
				map[0][j] = map[0][j + 1];
			}
			// 위쪽
			for (int i = 0; i < c1[0]; i++) {
				map[i][C - 1] = map[i + 1][C - 1];
			}
			// 오른쪽
			for (int j = C - 1; j > 0; j--) {
				map[c1[0]][j] = map[c1[0]][j - 1];
			}
			map[c1[0]][1] = 0;

			// 2 - 2 청소기 2 가동
			// 위
			for (int i = c2[0] + 1; i < R - 1; i++) {
				map[i][0] = map[i + 1][0];
			}

			// 왼쪽
			for (int j = 0; j < C - 1; j++) {
				map[R - 1][j] = map[R - 1][j + 1];
			}
			// 아래
			for (int i = R - 1; i > c2[0]; i--) {
				map[i][C - 1] = map[i - 1][C - 1];
			}
			// 오른쪽
			for (int j = C - 1; j > 0; j--) {
				map[c2[0]][j] = map[c2[0]][j - 1];
			}
			map[c2[0]][1] = 0;

			T--;
		}
		
		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					ans += map[i][j];
				}
			}
		}
		System.out.println(ans);
	} // end of main
} // end of class
