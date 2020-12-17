package jungol.begin.java;

import java.util.Scanner;

public class JungoL_1307 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		char[][] map = new char[n][n];
		char c = 'A';
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				map[j][i] = c++;
				if (c == 'Z' + 1) {
					c = 'A';
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	} // end of main

} // end of class
