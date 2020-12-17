package jungol.begin.java;

import java.util.Scanner;

public class Jungol_1309 {
	
	private static long res;
	private static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		sb = new StringBuilder();
		
		int n = sc.nextInt();
		res = 1;
		f(n);
		System.out.println(sb);
	}
	
	private static void f(int n) {
		if (n == 1) {
			sb.append(n).append("! ").append("= ").append("1").append("\n");
			sb.append(res);
			return;
		}
		sb.append(n).append("! ").append("= ").append(n).append(" * ").append(n - 1).append("!").append("\n");
		res = res * n;
		f(n - 1);
	}
} // end of class
