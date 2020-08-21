package bfs.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beakjoon_2178_Sungwon_BFS {
	private static int N, M;
	private static char[][] map;
	private static boolean[][] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		isVisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}// ------ 입력부 --------
		
		bfs(0, 0, 0);
		System.out.println(min);
		
		
		
	} // end of main
	
	static int min = 10000;
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1}; // 상하좌우
	private static void bfs(int row, int col, int cnt) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {row, col, ++cnt});
		isVisited[row][col] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < dr.length; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if (nr == N - 1 && nc == M - 1) {
					if (min > ++cur[2]) {
						min = cur[2];
					}
					break;
				}
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc] || map[nr][nc] == '0') {
					continue;
				}
				q.add(new int[] {nr, nc, cur[2] + 1}); 
				isVisited[nr][nc] = true;
			}
		}
	}
} // end of class
