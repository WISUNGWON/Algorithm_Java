package dfs.beakjoon;

import java.util.Scanner;

public class Beakjoon_1074_Z {
	private static int N, cnt;
	private static int r;
	private static int c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		search(0, 0, getSize(N));
	} // end of main

	private static int getSize(int n) {
		int result = 1;
		for (int i = 0; i < n; i++) {
			result *= 2;
		}
		return result;
	}

	private static void search(int i, int j, int size) {
		if (size == 1) {
			if (i == r && j == c) {
				System.out.println(cnt);

			} else {
				cnt++;
			}
			return;
		}
		
		int s = size / 2;
		
		search(i, j, s);
		search(i, j + s, s);
		search(i + s, j, s);
		search(i + s, j + s, s);
	}
} // end of class
