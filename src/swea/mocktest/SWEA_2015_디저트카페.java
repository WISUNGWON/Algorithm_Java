package swea.mocktest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2015_디저트카페 {
	private static int N, ans, startR, startC;
	private static int[][] map;
	private static boolean[] isChecked;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			isChecked = new boolean[101];
			startR = 0;
			startC = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // ----------- 입력부 ----------------
			
			ans = -1;
			for (int i = 0; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					startR = i;
					startC = j;
					dfs(i, j, 0, 0);
				}
			}

			sb.append("#").append(test_case).append(" ").append(ans);
		} // end of testCase
		System.out.println(sb.toString());
	} // end of main

	// 하우 하좌 상좌 상우
	static int[] dr = { 1, 1, -1, -1 }; // 시계 방향
	static int[] dc = { 1, -1, -1, 1 };
	private static void dfs(int r, int c, int dir, int cnt) {
		if (startR == r && startC == c && cnt != 0) {
			ans = ans < cnt ? cnt : ans;
			return;
		}

		for (int i = 0; i < 2; i++) {
			if (dir == 3 && i == 1) {
				break;
			}
			int nr = r + dr[dir + i];
			int nc = c + dc[dir + i];
			if (0 <= nr && nr < N && 0 <= nc && nc < N && !isChecked[map[nr][nc]]) { // 꺾어주기
				isChecked[map[nr][nc]] = true;
				dfs(nr, nc, dir + i, cnt + 1);
				isChecked[map[nr][nc]] = false;
			}
		}

	} // end of dfs
} // end of class
