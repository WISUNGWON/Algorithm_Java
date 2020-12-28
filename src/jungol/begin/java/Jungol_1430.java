package jungol.begin.java;

import java.util.Scanner;

public class Jungol_1430 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int ans = a * b * c;
		String str = Integer.toString(ans);
		int[] count = new int[10];
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i) - '0']++;
		}
		
		for (int i = 0; i < 9; i++) {
			sb.append(count[i]).append("\n");
		}
		sb.append(count[9]);
		
		System.out.println(sb);
	} // end of main
} // end of class
