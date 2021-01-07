package jungol.intermediate.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol_3517 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int q = Integer.parseInt(br.readLine());
		int[] arrQ = new int[q];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < q; i++) {
			arrQ[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = 0;
		for (int i = 0; i < q; i++) {
			int s = 0;
			int e = n - 1;
			int target = arrQ[i];
			boolean flag = false;
			while (s <= e) {
				// m 계산
				m = (s + e) / 2;
				if (target > arr[m]) {
					s = m + 1;
				} else if (target < arr[m]) {
					e = m - 1;
				} else {
					// 같음
					sb.append(m).append(" ");
					flag = true;
					break;
				}
			}
			if (!flag) {
				sb.append("-1 ");
			}
		}
		System.out.println(sb);
	} // end of main
} // end of class
