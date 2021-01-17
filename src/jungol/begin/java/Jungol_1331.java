package jungol.begin.java;

import java.util.Scanner;

public class Jungol_1331 {

	private static int n;
	private static char[][] map;
	private static int size;
	private static char alpa;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		size = 2 * n - 1;

		map = new char[size][size];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = ' ';
			}
		}
		alpa = 'A';
		solution(0, size / 2 + 1);

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == '\0') {
					System.out.print(" ");
				} else {
					System.out.print(map[i][j]);
				}
			}
			System.out.println();
		}
	} // end of main

	private static void solution(int sRow, int sCol) {
		if (sRow == size / 2) {
			// Todo 가운데 map에 담기
			map[size / 2][size / 2] = alpa;
			return;
		}

		sRow -= +1;
		// 왼
		while (sRow < size / 2) {

			map[++sRow][--sCol] = alpa++;
			if (alpa == 'Z' + 1) {
				alpa = 'A';
			}
		}
		// 아래
		while (sCol < size / 2) {
			map[++sRow][++sCol] = alpa++;
			if (alpa == 'Z' + 1) {
				alpa = 'A';
			}
		}
		// 오른
		while (sRow > size / 2) {
			map[--sRow][++sCol] = alpa++;
			if (alpa == 'Z' + 1) {
				alpa = 'A';
			}
		}
		// 위
		while (sCol > size / 2 + 1) {
			map[--sRow][--sCol] = alpa++;
			if (alpa == 'Z' + 1) {
				alpa = 'A';
			}
		}

		solution(sRow, sCol);
	}

}
