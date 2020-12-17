package jongol.begin.java;

import java.util.Scanner;

public class Jongol_1291 {
	
	static StringBuilder sb = new StringBuilder();
	static int dist, last, num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int s, e;
		while (true) {
			s = sc.nextInt();
			e = sc.nextInt();
			if (s < 2 || s > 9 || e < 2 || e > 9) {
				System.out.println("INPUT ERROR!");
				continue;
			} else {
				break;
			}
		} // end of while
		
		
		if (s >= e) {
			dist = -1;
		} else if (s < e) {
			dist = 1;
		}
		
		last = e + dist;
		
		for (int i = 1; i <= 9; i++) {
			
			num = 1 + Math.abs(s - e);
			int f = s - dist;
			while (num-- > 0) {
				f += dist;
				if (f * i < 10) {
					sb.append(f).append(" * ").append(i).append(" =  ").append(f * i).append("   ");
				} else {
					sb.append(f).append(" * ").append(i).append(" = ").append(f * i).append("   ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	} // end of main

} // end of class
