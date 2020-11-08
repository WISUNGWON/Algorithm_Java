package swea.mocktest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115_벌꿀채취 {

	static int N, M, C;
	static int[][] map, maxMap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// maxMap : 연속된 벌통에서 구한 최대 이익이 저장되는 Map (N - M 부분까지 씀)
			maxMap = new int[N][N - M + 1];
			makeMaxMap();
			sb.append("#").append(test_case).append(" ").append(comb()).append("\n");
		} // end of TC
		System.out.println(sb);
	} // end of main

	private static void makeMaxMap() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c <= N - M; c++) {
				makeMaxSubset(r, c, 0, 0, 0);
			}
		}
	}
	// 일꾼이 선택한 연속된 벌통에서 부분집합을 통해 꿀들을 선택하여 최대 수익 구하기
	private static void makeMaxSubset(int r, int c, int cnt, int sum, int profit) {

		if (sum > C) {
			return;
		}
		if (cnt == M) {
			if (maxMap[r][c - M] < profit) {
				maxMap[r][c - M] = profit;
			}
			return;
		}
		// 선택
		makeMaxSubset(r, c + 1, cnt + 1, sum + map[r][c], profit + map[r][c] * map[r][c]);
		// 비선택
		makeMaxSubset(r, c + 1, cnt + 1, sum, profit);
	}

	private static int comb() {

		int max = 0, aProfit = 0, bProfit = 0;
		for (int aRow = 0; aRow < N; aRow++) { 
			for (int aCol = 0; aCol <= N - M; aCol++) { // 일꾼 A 선택
				aProfit = maxMap[aRow][aCol];
				// 일꾼 B 선택
				// 같은 행 처리
				bProfit = 0;
				for (int bCol = aCol + M; bCol <= N - M; bCol++) { // j2 = j + M : M을 더한 위치부터 시작해야 벌통들이 겹치지 않음
					if (bProfit < maxMap[aRow][bCol]) {
						bProfit = maxMap[aRow][bCol];
					}
				}
				// 다른 행 처리
				for (int bRow = aRow + 1; bRow < N; bRow++) {
					for (int bCol = 0; bCol <= N - M; bCol++) {
						if (bProfit < maxMap[bRow][bCol]) {
							bProfit = maxMap[bRow][bCol];
						}
					}
				}
				if (max < aProfit + bProfit) {
					max = aProfit + bProfit;
				}
			}
		}
		return max;
	}
}
