package bruteforce.backjoon;

import java.util.Scanner;

public class Beakjoon_10819 {
	private static int n, max;
	private static int[] numbers;
	private static boolean[] isVisited;
	private static int[] pickedNums;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		numbers = new int[n + 1];
		isVisited = new boolean[n + 1];
		pickedNums = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			numbers[i] = sc.nextInt();
		}

		max = Integer.MIN_VALUE;
		dfs(1);

		System.out.println(max);
	} // end of main

	private static void dfs(int step) {
		if (step == n + 1) {
			// max구하기
			int tempMax = 0;
			for (int i = 1; i <= n - 1; i++) {
				tempMax += Math.abs(pickedNums[i] - pickedNums[i + 1]);
			}
			if (tempMax > max) {
				max = tempMax;
			}
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (isVisited[i]) {
				continue;
			}
			isVisited[i] = true;
			pickedNums[step] = numbers[i];
			dfs(step + 1);
			isVisited[i] = false;
		}
	}
} // end of class
