package jungol.begin.java;

import java.util.Scanner;

public class Jungol_1169 {
	
	private static int n,m;
	private static StringBuilder sb;
	private static int[] selectedNums;
	private static boolean[] isPicked;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		n = sc.nextInt();
		m = sc.nextInt();
		
		selectedNums = new int[n];
		isPicked = new boolean[7];
		switch (m) {
		case 1:
			m1(0);
			break;
		case 2:
			m2(0, 1);
			break;
		case 3:
			m3(0);
			break;
		}
		
		System.out.println(sb);
	} // end of main

	private static void m1(int step) {
		if (step == n) {
			addToBuilder();
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			selectedNums[step] = i;
			m1(step + 1);
		}
	} // end of m1
	
	private static void m2(int step, int preNum) {
		if (step == n) {
			addToBuilder();
			return;
		}
		
		for (int i = preNum; i <= 6; i++) {
			selectedNums[step] = i;
			m2(step + 1, i);
		}
	} // end of m2
	
	private static void m3(int step) {
		if (step == n) {
			addToBuilder();
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			if (isPicked[i]) {
				continue;
			}
			selectedNums[step] = i;
			isPicked[i] = true;
			m3(step + 1);
			isPicked[i] = false;
		}
	} // end of m3
	
	private static void addToBuilder() {
		for (int i = 0; i < n - 1; i++) {
			sb.append(selectedNums[i]).append(" ");
		}
		sb.append(selectedNums[n - 1]).append("\n");
	}
} // end of class
