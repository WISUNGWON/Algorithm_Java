package swea.level.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1289 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int cnt;
		String memory;
		char[] memoryArr;
		char[] initArr;
		
		for (int test = 1; test <= T; test++) {
			
			// -------------------------- 입력부 ---------------------------------
			memory = br.readLine();
			memoryArr = memory.toCharArray();
			initArr = new char[memoryArr.length];
			for (int i = 0; i < initArr.length; i++) { // initArr '0'으로 초기화
				initArr[i] = '0';
			}
			cnt = 0;
		
			// -------------------------- 핵심 알고리즘 ---------------------------------
			for (int i = 0; i < memory.length(); i++) {
				if (memoryArr[i] != initArr[i] && memoryArr[i] == '1') { 
					for (int j = i; j < initArr.length; j++) {
						initArr[j] = '1';
					}
					cnt++;
				} else if (memoryArr[i] != initArr[i] && memoryArr[i] == '0') {
					for (int j = i; j < initArr.length; j++) {
						initArr[j] = '0';
					}
					cnt++;
				}
			}
			
			// -------------------------- 출력부 ---------------------------------
			System.out.println("#" + test + " " + cnt);
		}
		
		br.close();

	} // end of main

} // end of class
