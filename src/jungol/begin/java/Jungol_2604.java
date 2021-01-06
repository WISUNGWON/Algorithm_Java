package jungol.begin.java;

import java.util.Scanner;

public class Jungol_2604 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int ans = 10;
		for (int i = 0; i < str.length() - 1; i++) {
			char a = str.charAt(i);
			char b = str.charAt(i + 1);
			if (a == b) {
				ans += 5;
			} else {
				ans += 10;
			}
		}
		
		System.out.println(ans);
	} // end of main
} // end of class
