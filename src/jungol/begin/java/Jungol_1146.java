package jungol.begin.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol_1146 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0;
		while(s < n - 1) {
			int min = Integer.MAX_VALUE;
			int idx = 0;
			for (int i = s; i < n; i++) {
				if (min > arr[i]) {
					min = arr[i];
					idx = i;
				}
			}
			
			int temp = arr[s];
			arr[s] = min;
			arr[idx] = temp;
			
			for (int i = 0; i < n - 1; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append(arr[n - 1]).append("\n");
			s++;
		}
		
		System.out.println(sb);
	} // end of main
} // end of class
