package bfs.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 욕심쟁이 판다
/** 
 *  못 풀었음
 *  첫 시도 메모리 초과, 두 번째 틀렸습니다.
 *  2중 for문을 사용하지 말아야 하나?
 *  
 *  idea 
 *  2중 for문으로 각각 bfs실행
 *  시간을 줄이기 위해 int형인 isVisited 배열을 선언
 *  isVisited 배열에 방문했던 곳에 판다가 살 수 있는 최대 길이 저장
 *  
 * */

public class Beakjoon_1937 {

	private static int[][] map;
	private static int N;
	private static int max;
	private static int[][] isVisited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		isVisited = new int[N][N];
		max = -1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // ------------- 입력부 ---------------
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (isVisited[i][j] == 0) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(max);
	} // end of main
	// 맵의 지도를 바꾸면서 한번 계산한 값으로 바꿔주기 / 비지티드 써서 바꿔주기
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};
	private static void bfs(int row, int col) {
		int cnt = 1;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {row, col, map[row][col]});
		isVisited[row][col] = cnt;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < dc.length; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] > cur[2]) {
					if (isVisited[nr][nc] == 0) {
						q.add(new int[] {nr, nc, map[nr][nc]});
						isVisited[nr][nc] = isVisited[cur[0]][cur[1]] + 1;
					} else if (isVisited[nr][nc] != 0) {
						isVisited[nr][nc] += isVisited[cur[0]][cur[1]];
					}
					if (max < isVisited[nr][nc]) {
						max = isVisited[nr][nc];
					}
				}
			}
		}
	}
} // end of class
