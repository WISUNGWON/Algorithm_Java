package swea.mocktest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4008_Answel {

	public static int N, min, max;
	public static int[] ops, opsCnt, numbers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		opsCnt = new int[4]; // 각 연산자 개수 배열

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			numbers = new int[N];
			ops = new int[N - 1]; // 연산자 배열

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				opsCnt[i] = Integer.parseInt(st.nextToken());
			} // 연산자 개수 저장

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			} // 숫자 저장

			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			permutation(0);
			sb.append("#").append(test_case).append(" ").append((max - min)).append("\n");
		} // end of TC
		System.out.println(sb);
	} // end of main
	
	private static void permutation(int cnt) { // 연산자의 순열 생성
		if (cnt == N - 1) { // 연산자 순열 완성
			calc();
			return;
		}
		// 모든 연산자를 다 시도해봄 
		for (int i = 0; i < 4; i++) {// i:연산자, +:0 -:1 *:2 /:3
			if (opsCnt[i] == 0) {
				continue;
			}
			ops[cnt] = i;
			opsCnt[i]--;
			permutation(cnt + 1); // 연산자 선택 후 다음으로 넘어가기
			opsCnt[i]++;
		}
	}

	private static void calc() { // 연산자의 순열 상태를 이용하여 수식계산
		
		int result = numbers[0];
		for (int i = 1; i < N; i++) {
			int curNumber = numbers[i];
			switch (ops[i - 1]) {
			case 0:
				result += curNumber;
				break;
			case 1:
				result -= curNumber;
				break;
			case 2:
				result *= curNumber;
				break;
			case 3:
				result /= curNumber;
				break;
			}
		}
		max = Math.max(max, result);
		min = Math.max(min, result);
	}
} // end of class
