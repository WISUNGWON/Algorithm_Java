package swea.level.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 보호필름 (부분집합)
/** 부분집합과 다르지 않고, 굳이 순열을 적용하지말고 백트래킹을 사용해서 검사해보기 */
public class SWEA_2112 {

	static int D; // 행의 개수
	static int W; // 열의 개수
	static int K; // 연속되어져야 하는 기준
	static int[][] film;
	static int ans; // 정답을 저장하는 변수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			film = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = Integer.MAX_VALUE;
			solve(0, 0);
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		} // end of TC
		System.out.println(sb);
	} // end of main

	// 각 행에 대해 3가지 경우의 수를 검사하는 재귀함수
	// row 행에 대해서, 그냥 두는 경우. A로 바꾸는 경우. B로 바꾸는 경우 세가지에 대해 검사.
	// 바꾼 횟수를 cnt에 기억하고 다닌다.
	private static void solve(int row, int cnt) {
		// 현재 셀이 통과되는 상태라면, 지금까지 변경한 변경횟수 중 가장 작은 값을 기억해 나가자.
		if (isOK()) {
			ans = Math.min(ans, cnt);
			return;
		}
		// 가지치기. cnt가 이미 발견된 ans보다 커졌으면 더 볼것도 없음.
		if (ans < cnt) {
			return;
		}
		// row가 D에 도달했으면 더이상 검사할 행이 남아있지 않음. 끝.
		if (row == D) {
			return;
		}

		// 현재 행을 그대로 두고 다음행으로 이동(약을 바르지 않음)
		solve(row + 1, cnt);

		// 원래 값으로 돌려놓기 위해서 현재 행의 값을 기억.
		int[] tmp = new int[W];
		for (int i = 0; i < W; i++) {
			tmp[i] = film[row][i];
		}

		// 현재 행을 A로 다 바꿔버리고 다음 행으로 이동.
		// A로 다 바꿔버림.
		for (int i = 0; i < W; i++) {
			film[row][i] = 0;
		}
		solve(row + 1, cnt + 1);
		// 현재 행을 B로 다 바꿔버리고 다음 행으로 이동.
		for (int i = 0; i < W; i++) {
			film[row][i] = 1;
		}
		solve(row + 1, cnt + 1);
		// 다시 원복
		for (int i = 0; i < W; i++) {
			film[row][i] = tmp[i];
		}
	}

	// 필름이 통과되는지 확인
	private static boolean isOK() {
		// 모든 열에 대해서 검사.
		for (int j = 0; j < W; j++) {
			// 연속된 카운트 수를 1로 잡고.
			int cnt = 1;
			boolean isok = false;
			// 두번째 행부터 검사하면서, 나와 전행이 같으면 카운트를 ++
			for (int i = 1; i < D; i++) {
				if (film[i][j] == film[i - 1][j])
					cnt++;
				else
					cnt = 1;
				// 만약 카운트가 K와 같아지면, 이미 통과이므로 반복을 그만해도 됨
				if (cnt == K) {
					isok = true;
					break;
				}
			}
			// cnt가 K를 만족해서 반복을 다 못돌고 break만나서 왔을 수도 있고.(이 경우엔 isok가 true)
			// 반복계수가 주어진 조건을 다 채워서 왔을수도있음.(이 경우엔 isok가 false)
			if (!isok)
				return false;
		}
		// 모든 열이 검사가 끝났는데.. 여전히 코드가 살아서 여기까지 왔다면 return true;
		return true;
	}
} // end of class
