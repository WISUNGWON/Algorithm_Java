package jungol.begin.java;

import java.util.Scanner;

public class Jungol_1161 {
	
	private static int count;
	private static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		int n = sc.nextInt();
		
		move("1", "2", "3", n);
		sb.append("총 이동 횟수 : " ).append(count);
		System.out.println(sb);
	} // end of main

	private static void move(String from, String by, String to, int n) {
		if (n == 1) {
			++count;
			sb.append(n).append(" : ").append(from).append(" -> ").append(to).append("\n");
		} else {
			move(from, to, by, n - 1);
			++count;
			sb.append(n).append(" : ").append(from).append(" -> ").append(to).append("\n");
			move(by, from, to, n - 1);
		}
	}
} // end of class
