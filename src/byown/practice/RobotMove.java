package com.ssafy.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class RobotMove {
	
	public static char[][] square;
	
	public static void main(String[] args) throws IOException {
//		S공백, W벽, A(우), B(좌, 우), C(상, 하, 좌, 우)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T, N, move;
		
		T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			square = new char[N][N];
			move = 0;
			System.out.println("fist move : " + move);
			for (int j = 0; j < N; j++) {
				char[] chArr = br.readLine().replace(" ", "").toCharArray(); //replace로 하는 방식 말고 다른 방식으로도 해보기
				square[j] = chArr;
			}
			
			// 로봇이동 시작
			for (int j = 0; j < N; j++) {
				for (int z = 0; z < N; z++) {
					// 로봇 A이면
					if (square[j][z] == 'A') {
						// 우측이동
						for (int m = z; m < N - z; m++) {
							if (square[j][m + 1] == 'S') {
								move++;
							} else {
								break;
							}
						} 
						System.out.println("A : " + move);
					}
					// 로봇 B이면
					else if (square[j][z] == 'B') {
						// 우측이동
						for (int m = z; m < N - z; m++) {
							if (square[j][m + 1] == 'S') {
								move++;
							} else {
								break;
							}
						}
						// 좌측이동
						for (int m = z; m > 0; m--) {
							if (square[j][m - 1] == 'S') {
								move++;
							} else {
								break;
							}
						}
						System.out.println("A + B : " + move);
					}
					// 로봇 C이면
					else if (square[j][z] == 'C') {
						// 우측이동
						for (int m = z; m < N - z; m++) {
							if (square[j][m + 1] == 'S') {
								move++;
							} else {
								break;
							}
						}
						System.out.println("우측 : " + move);
						// 좌측이동
						for (int m = z; m > 0; m--) {
							if (square[j][m - 1] == 'S') {
								move++;
							} else {
								break;
							}
						}
						System.out.println("좌측 : " + move);
						// 아래이동
						for (int m = j; m < N - j; m++) {
							if (square[m + 1][z] == 'S') {
								move++;
							} else {
								break;
							}
						}
						System.out.println("아래 : " + move);
						// 위 이동
						for (int m = j; m > 0; m--) {
							if (square[m - 1][z] == 'S') {
								move++;
							} else {
								break;
							}
						}
						System.out.println("위 : " + move);
						System.out.println("A + B + C: " + move);
					}
				}
			}
			
			bw.write("#" + i + " " + move + "\n");
		} // end of for
		
		br.close();
		bw.flush();
		bw.close();

	} // end of main

} // end of class
