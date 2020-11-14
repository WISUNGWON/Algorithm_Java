package samsung.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beakjoon_16235_나무재테크 {

	private static int N, M, K;
	private static ArrayList<Tree2>[][] treeMap;
	private static int[][] map, simulMap;
	private static Queue<Tree2> deadTree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		simulMap = new int[N][N];
		treeMap = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				simulMap[i][j] = 5;
				treeMap[i][j] = new ArrayList<Tree2>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			treeMap[y][x].add(new Tree2(age));
		} // -------- 입력부 -------------

		deadTree = new LinkedList<Tree2>();
		while (K-- > 0) {

			// 봄 :양분 먹기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!treeMap[i][j].isEmpty()) {
						eatEnergy(i, j);
					}
				}
			}

			// 여름
			while (!deadTree.isEmpty()) {
				Tree2 cur = deadTree.poll();
				simulMap[cur.row][cur.col] = cur.age / 2; // 죽은 나무의 나이를 2로 나눈 값이 해당 칸의 양분으로 추가됨 (소수점은 버림)
			}

			// 가을
//		나이가 5의 배수인 나무들의 인접 8방에는 나이가 1인 나무가 생김 (맵 벗어나면 안생김)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!treeMap[i][j].isEmpty()) {
						fall(i, j); // 8방 탐색하고 나이가 1인 나무 add해주기
					}
				}
			}

			// 겨울 (초기 맵에서 양분 추가)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					simulMap[i][j] += map[i][j];
				}
			}
		} // end of K
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += treeMap[i][j].size();
			}
		}
		
		System.out.println(ans);
	} // end of main

	private static int[] dr = { 1, -1, 0, 0, 1, 1, -1, -1 };
	private static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	private static void fall(int r, int c) {
		for (int i = 0; i < treeMap[r][c].size(); i++) {
			Tree2 cur = treeMap[r][c].get(i);
			if (cur.age % 5 == 0) { // 5의 배수이면
				for (int j = 0; j < 8; j++) {
					int nr = r + dr[j];
					int nc = c + dc[j];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						treeMap[nr][nc].add(new Tree2(1)); // age1 추가
					}
				}
			}
		}
	}

	private static void eatEnergy(int r, int c) {
		Collections.sort(treeMap[r][c]); // 나이 오름차순으로 정렬
		for (int i = 0; i < treeMap[r][c].size(); i++) {
			// simulMap에 있는 양분 먹고 갱신하기
			Tree2 cur = treeMap[r][c].get(i);
			int energy = simulMap[r][c];
			energy -= cur.age;
			if (energy >= 0) {
				cur.age++;
			} else {
				simulMap[r][c] = energy += cur.age;
				cur.row = r;
				cur.col = c;
				deadTree.add(cur);
				treeMap[r][c].remove(i);
			}
		}
	}

} // end of class

class Tree2 implements Comparable<Tree2> {
	int age;
	int row;
	int col;

	public Tree2(int age) {
		this.age = age;
	}

	public int compareTo(Tree2 o) { // 오름차순으로 정렬
		return this.age - o.age;
	}
}
