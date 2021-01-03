package jungol.begin.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol_1158 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 구현
		int s = 1;
		while (s < n) {
			boolean flag = false;
			int idx = 0;
			// 앞 수들과 비교
			for (int i = 0; i < s; i++) {
				if (arr[s] < arr[i]) {
					idx = i;
					flag = true;
					break;
				}
			}
			
			if (flag) {
				// 배열 바꾸기
				int temp = arr[s];
				for (int i = 0; i < s - idx; i++) {
					arr[s - i] = arr[s - i - 1];
				}
				arr[idx] = temp;
			} 
			
			// 출력 준비
			for (int i = 0; i < n - 1; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append(arr[n - 1]).append("\n");
			s++;
		}
		
		System.out.println(sb);
	} // end of main
} // end of class
