package dp3.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon_11404_Floyd {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int INF = 10000000;
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); 
			int to = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if (dp[from][to] == 0) {
				dp[from][to] = v;
			} else if (dp[from][to] > v) {
				dp[from][to] = v;
			}
			
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dp[i][j] == 0 && i != j) {
					dp[i][j] = INF;
				}
			}
		}
		
		// k = 거쳐가는 노드
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (dp[i][k] + dp[k][j] < dp[i][j]) {
						dp[i][j] = dp[i][k] + dp[k][j];
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dp[i][j] == INF) {
					dp[i][j] = 0;
				}
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	} // end of main
} // end of class
