package jungol.begin.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Jungol_1459 {

	static int[] arr;
	static ArrayList<Integer> arrList;
	static int startNum;
	static boolean[] visited;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		visited = new boolean[N + 1];
		arrList = new ArrayList<Integer>();

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= N; i++) {
			visited[i] = true; 
			startNum = i;
			solve(i);
			visited[i] = false;
		}
		Collections.sort(arrList); 
		int size = arrList.size();
		sb.append(size).append("\n");
		for (int i = 0; i < size - 1; i++) {
			sb.append(arrList.get(i)).append("\n");
		}
		sb.append(arrList.get(size - 1));
		
		System.out.println(sb);
	} // end of main

	public static void solve(int i) {
		if (!visited[arr[i]]) { 
			visited[arr[i]] = true; 
			solve(arr[i]);
			visited[arr[i]] = false;
		}
		if (arr[i] == startNum) {
			arrList.add(startNum);
		}
	}
} // end of class