package jungol.begin.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jungol_1697 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		int[] q = new int[n];
		int start = 0;
		int end = 0;
		int size = 0;
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			// offer
			if (str.length() >= 3) {
				String[] temp = str.split(" ");
				int a = Integer.parseInt(temp[1]);
				q[end++] = a;
				size++;
			} else {
				char order = str.charAt(0);
				// poll
				if (order == 'o') {
					if (size - 1 < 0) {
						sb.append("empty").append("\n");
					} else {
						sb.append(q[start++]).append("\n");
						size--;
					}
				} else {
					sb.append(size).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	} // end of main
} // end of class
