package jungol.begin.java;

import java.util.Scanner;

public class Jungol_1523 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		if (n > 100 || n <= 0 || m > 3 || m < 0) {
			sb.append("INPUT ERROR!");
		} else {
			switch (m) {
			case 1:
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= i; j++) {
						sb.append("*");
					}
					sb.append("\n");
				}
				break;
			case 2:
				for (int i = n; i > 0; i--) {
					for (int j = 1; j <= i; j++) {
						sb.append("*");
					}
					sb.append("\n");
				}
				break;
			case 3:
				for (int i = 0; i < n; i++) {

					for (int j = 1; j < n - i; j++) {
						sb.append(" ");
					}

					for (int k = 0; k < 2 * i + 1; k++) {
						sb.append("*");
					}
					sb.append("\n");
				}
				break;
			}
		}

		System.out.println(sb.toString());
	} // end of main
} // end of class
