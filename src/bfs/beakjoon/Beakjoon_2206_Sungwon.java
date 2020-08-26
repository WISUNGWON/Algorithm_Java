package bfs.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beakjoon_2206_Sungwon {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		} // -------------- 입력부 ---------------
		boolean[][][] isVisited = new boolean[N][M][2]; // 논리적으로 mode를 변경해서 방문할 수 있도록 3차원 배열 선언
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j]+ " ");
//			}
//			System.out.println();
//		} for 디버깅
		
		int cnt = -1;
		int[] dr = {-1, 1, 0, 0}; // 상하좌우
		int[] dc = {0, 0, -1, 1}; // 상하좌우
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {0, 0, 0, 1});
		isVisited[0][0][0] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int mode = cur[2];
			if (r == N - 1 && c == M - 1) {
				cnt = cur[3];
				break;
			}
			for (int i = 0; i < dr.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !isVisited[nr][nc][mode]) {
					if (map[nr][nc] == '0') {
						q.add(new int[] {nr, nc, mode, cur[3] + 1}); 
						isVisited[nr][nc][mode] = true;
					} else if (mode == 0) {
						q.add(new int[] {nr, nc, 1, cur[3] + 1});
						isVisited[nr][nc][1] = true;
					}
				}
			}
		}
		System.out.println(cnt);
	} // end of main
} // end of class
