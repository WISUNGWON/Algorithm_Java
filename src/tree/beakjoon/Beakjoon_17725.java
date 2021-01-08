package tree.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon_17725 {

	private static int n;
	private static int[] arr;
	private static int[][] arr2;
	private static int arr2Idx;
	private static StringTokenizer st;
	private static BufferedReader br;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		arr = new int[n + 1];
		arr2 = new int[n + 1][2];
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}

		arr2Idx = 0;
		solution();

		if (arr2Idx > 0) {
			solution();
		}

		for (int i = 2; i <= n; i++) {
			sb.append(arr[i]).append("\n");
		}

		System.out.println(sb);
	} // end of main

	private static void solution() throws IOException {
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (arr[a] == 1 && arr[b] == b && arr[a] == a) {
				arr[b] = 1;
				continue;
			} else if (arr[b] == 1 && arr[a] == a && arr[b] == b) {
				arr[a] = 1;
				continue;
			}

			if (arr[a] != a) {
				arr[b] = a;
				continue;
			} else if (arr[b] != b) {
				arr[a] = b;
				continue;
			}

			if (arr[a] == a && arr[b] == b) {
				arr2[arr2Idx++][0] = a;
				arr2[arr2Idx++][1] = b;
			}
		}
	}
} // end of class
