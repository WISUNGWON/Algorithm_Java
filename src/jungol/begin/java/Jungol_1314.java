package jungol.begin.java;

import java.util.Scanner;

public class Jungol_1314 {
	private static int n;
	private static StringBuilder sb;
	private static char[][] arr;
	private static char ch;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new char[n][n];
		ch = 'A';
		sb = new StringBuilder();
		
		solve(0);
		
		System.out.println(sb);
		
	} // end of main
	private static void solve(int col) {
		if (col == n) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - 1; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append(arr[i][n - 1]).append("\n");
			}
			return;
		}
		
		if (col % 2 == 1) {
			for (int i = n - 1; i >= 0; i--) {
				arr[i][col] = ch++;
				if(ch == 'Z' + 1) {
					ch = 'A';
				}
			}
		} else {
			for (int i = 0; i < n; i++) {
				arr[i][col] = ch++;
				if(ch == 'Z' + 1) {
					ch = 'A';
				}
			}
		}
		
		solve(col + 1);
	}
} // end of class
