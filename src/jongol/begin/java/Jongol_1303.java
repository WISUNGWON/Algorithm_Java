package jongol.begin.java;

import java.util.Scanner;

public class Jongol_1303 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for (int i = 1; i <= n * m; i++) {
			if (i % m == 0) {
				sb.append(i).append("\n");
				continue;
			}
			sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	} // end of main
}
