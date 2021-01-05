package jungol.intermediate.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Jungol_1328 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<int[]> st = new Stack<int[]>();
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[] printArr = new int[n];
		int idx = 0;
		for (int i = n; i > 0; i--) {
			int curH = arr[i];
			while (!st.empty()) {
				int[] building = st.peek();
				if (building[1] > curH) {
					printArr[idx++] = building[0];
					break;
				}
				st.pop();
			}

			if (st.empty()) {
				printArr[idx++] = 0;
			}
			st.push(new int[] { i, curH });
		}

		for (int i = n - 1; i >= 0; i--) {
			sb.append(printArr[i]).append("\n");
		}

		System.out.println(sb.toString());
	} // end of main
} // end of class
