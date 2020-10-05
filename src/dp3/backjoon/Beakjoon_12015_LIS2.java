package dp3.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon_12015_LIS2 {
	
	private static int N, idx, ans;
	private static int[] a, dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		a = new int[N];
		dp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = a[0];
		idx = 0;
		for (int i = 1; i < N; i++) {
			if (dp[idx] < a[i]) {
				dp[++idx] = a[i];
			} else {
				int l = makeLIS(a[i]);
				dp[l] = a[i];
			}
		}
		ans = idx + 1;
		System.out.println(ans);
	} // end of main

	private static int makeLIS(int i) {
		int start = 0;
		int end = idx + 1;
		while (start < end) {
			int m = (start + end) / 2;
			if (dp[m] < i) {
				start = m + 1;
			} else {
				end = m;
			}
		}
		return end;
	}
} // end of class
