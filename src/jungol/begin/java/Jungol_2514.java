package jungol.begin.java;

import java.util.Scanner;

public class Jungol_2514 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int numK = 0;
		int numI = 0;
		char ch;
		for (int i = 0; i < str.length() - 2; i++) {
			ch = str.charAt(i);
			if (ch == 'K') {
				if (str.charAt(i + 1) == 'O') {
					if (str.charAt(i + 2) == 'I') {
						numK++;
					}
				}
			}
			if (ch == 'I') {
				if (str.charAt(i + 1) == 'O') {
					if (str.charAt(i + 2) == 'I') {
						numI++;
					}
				}
			}
		}
		
		System.out.println(numK);
		System.out.println(numI);
	} // end of main
} // end of class
