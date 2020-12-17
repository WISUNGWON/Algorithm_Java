package jongol.begin.java;

import java.util.Scanner;

public class Jongol_2046 {
	
	private static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		map = new int[n][n];
		
		switch (m) {
		case 1:
			one(n);
			break;
		case 2:
			two(n);
			break;
		case 3:
			three(n);
			break;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	} // end of main
	private static void three(int n) {
		for (int i = 0; i < n; i++) {
			int num = 0;
			for (int j = 0; j < n; j++) {
				map[i][j] = num += i + 1;
			}
		}
	}
	private static void one(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = i + 1;
			}
		}		
	}
	private static void two(int n) {
		int num = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i % 2 == 1) {
					map[i][j] = --num;
				} else {
					map[i][j] = num++;
				}
			}
		}		
	}
} // end of class
