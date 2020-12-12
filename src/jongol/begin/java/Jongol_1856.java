package jongol.begin.java;

import java.util.Scanner;

public class Jongol_1856 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int i, j;
		
		int[][] arr = new int[n][m];
		
		int num = 0;
		for (i = 0; i < n; i++) {
			if (i % 2 == 0) {
				for (j = 0; j < m; j++) {
					arr[i][j] = ++num;
				}
			} else if (i % 2 == 1) {
				for (j = m - 1; j >= 0; j--) {
					arr[i][j] = ++num;
				}
			}
		}
		
		for (int k = 0; k < n; k++) {
			for (int k2 = 0; k2 < m; k2++) {
				sb.append(arr[k][k2]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	} // end of main
} // end of class
