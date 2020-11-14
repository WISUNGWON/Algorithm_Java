package samsung.beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 시뮬레이션 문제 2차원배열에 나무정보를 넣어놓고 완탐하면 시간이 많이 걸림 나무의 정보들만 큐에 넣어놓고 반복하면 시간이 절약됨
 */
public class Beakjoon_16235_나무재테크_Answel {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 땅의 크기, 1 ≤ N ≤ 10
		int M = Integer.parseInt(st.nextToken()); // 심은 나무의 수, 1 ≤ M ≤ N^2
		int K = Integer.parseInt(st.nextToken()); // 지난 년 수, 1 ≤ K ≤ 1,000

		int[][] A = new int[N][N]; // 겨울에 추가할 영양분 고정값
		int[][] power = new int[N][N]; // 영양분 관리할 배열
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken()); // 겨울에 추가되는 양분의 양, 1 <= A[r][c] <= 100
				power[i][j] = 5; // 처음에 양분 초기값 5
			}
		}

		LinkedList<Tree> ll = new LinkedList<Tree>(); // 좌표에 있는 나무정보, 나이순
		// 나이가 적은 나무부터 정렬
		// 1. 우선순위 큐
		// 2. 큐, 최초에 한번만 정렬, 아기나무 큐의 앞쪽에 추가
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1; // 행, 상도가 심은 나무정보
			int y = Integer.parseInt(st.nextToken()) - 1; // 열
			int z = Integer.parseInt(st.nextToken()); // 나이 1<= z <= 10
			ll.add(new Tree(x, y, z));
		}

		ll.sort(new Comparator<Tree>() {
			@Override
			public int compare(Tree a, Tree b) { // 비교기준, a-b :오름차순
				return a.age - b.age;
			}
		});

		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 }; // 좌상, 상, 우상, 좌, 우, 좌하, 하, 우하
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 }; // 좌상, 상, 우상, 좌, 우, 좌하, 하, 우하
		Deque<Tree> tree = new ArrayDeque<Tree>(ll); // 전체 나무
		Deque<Tree> dieTree = new ArrayDeque<Tree>(); // 죽은 나무
		Deque<Tree> babyTree = new ArrayDeque<Tree>(); // 아기 나무
		for (int year = 0; year < K; year++) {
//		봄 	: 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
//		각각의 나무는 자기 칸에 있는 양분만 먹음. 하나의 칸에 여러 개의 나무가 있다면, 나이어린 나무부터 양분을 먹음
//		만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
			int size = tree.size(); // 현재 큐의 크기를 저장
			for (int i = 0; i < size; i++) {
				Tree t = tree.poll();
				if (power[t.r][t.c] >= t.age) {
					power[t.r][t.c] -= t.age;
					t.age++;
					tree.offer(t); // 큐의 맨뒤에 추가
					if (t.age % 5 == 0) {
						babyTree.offer(t); // 아이를 낳을수 있는 나무의 목록
					}
				} else {
					dieTree.offer(t); // 죽은 나무 저장
				}
			}
//		여름 : 봄에 죽은 나무가 양분으로 변함, 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가됨. 소수점 아래는 버린다.
			size = dieTree.size();
			for (int i = 0; i < size; i++) {
				Tree t = dieTree.poll();
				power[t.r][t.c] += t.age / 2;
			}
//		가을 : 나무가 번식한다. 번식하는 나무는 나이가 5의 배수이어야 하며, 땅의 크기 내에서 상하좌우, 대각 8방향에 나이가 1인 나무가 생긴다.
			size = babyTree.size();
			for (int i = 0; i < size; i++) {
				Tree t = babyTree.poll();
				for (int j = 0; j < dc.length; j++) {
					int nr = t.r + dr[j];
					int nc = t.c + dc[j];
					if (0 <= nr && nr < N && 0 <= nc && nc < N) { // 배열 범위
						tree.push(new Tree(nr, nc, 1)); // 맨 앞에 추가
					}
				}
			}
//		겨울 : 각 칸에 추가되는 양분의 양은 A[r][c]
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					power[i][j] += A[i][j];
				}
			}
		} // end of for year
		System.out.println(tree.size()); // K년이 지난후 살아남은 나무의 수를 출력
	} // end of main

	public static class Tree {
		int r;
		int c;
		int age;

		public Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}
	}
} // end of class