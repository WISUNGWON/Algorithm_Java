package backtracking.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1182 부분수열의 합
public class Beakjoon_1182 {

	private static boolean[] isVisited;
	private static int N;
	private static int S;
	private static int[] input;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		S = Integer.parseInt(st.nextToken());
		ans = 0; // 정답 개수
		st = new StringTokenizer(br.readLine());
		input = new int[N];
		for (int i = 0; i < input.length; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		isVisited = new boolean[N]; // 방문한 것은 input의 인덱스로
		subset(0);
		System.out.println(ans);
	}

	private static void subset(int cnt) {
		if (cnt == N) {
//			for (int i = 0; i < N; i++) {
//				if (isVisited[i]) {
//					System.out.print(input[i] + " ");
//				} else {
//					System.out.print("X ");
//				}
//			}
//			System.out.println();
			int sum = 0; // 공집합인 경우 어떻게 없애지?
			boolean isZero = true;
			for (int i = 0; i < N; i++) {
				if (isVisited[i]) {
					sum += input[i];
					isZero = false;
				}
			}
			if (isZero) {
				sum = 1000001;
			}
			if (sum == S) {
				ans++;
			}
			return;
		}
		isVisited[cnt] = true;
		subset(cnt + 1);
		isVisited[cnt] = false;
		subset(cnt + 1);
	}

}
