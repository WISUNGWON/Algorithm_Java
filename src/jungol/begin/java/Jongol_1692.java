package jongol.begin.java;

import java.util.Scanner;

public class Jongol_1692 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		sb.append(x * (y % 10)).append("\n");
		sb.append(x * ((y % 100) / 10)).append("\n");
		sb.append(x * (y / 100)).append("\n");
		sb.append(x * y);
		System.out.println(sb);
	} // end of main
} // end of class
