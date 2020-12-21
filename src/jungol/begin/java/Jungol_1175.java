package jungol.begin.java;

import java.util.Scanner;

public class Jungol_1175 {

	private static int n, m;
	private static int[] selectedNum;
	private static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		n = sc.nextInt();
		m = sc.nextInt();
		
		selectedNum = new int[n];
		
		solve(0, 0);
		System.out.println(sb);
	} // end of main

	private static void solve(int step, int sum) {
		if (step == n) {
			if (sum == m) {
				for (int i = 0; i < n - 1; i++) {
					sb.append(selectedNum[i]).append(" ");
				}
				sb.append(selectedNum[n - 1]).append("\n");
			}
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			selectedNum[step] = i;
			solve(step + 1, sum + i);
		}
	}
	
} // end of class
