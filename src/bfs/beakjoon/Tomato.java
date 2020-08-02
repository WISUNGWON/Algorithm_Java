package bfs.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken()); //세로
		int N = Integer.parseInt(st.nextToken()); //가로
		int[][] map = new int[N][M];
		int[][] day = new int[N][M];
		Queue<int[]> queue = new LinkedList();
		int min = 0;
		int[] dir_row = new int[] { -1, 1, 0, 0 };
		int[] dir_col = new int[] { 0, 0, -1, 1 };
		int cntBaby = 0;

		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int col = 0; col < M; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				if (map[row][col] == 1) {
					queue.offer(new int[] { row, col, 0 });
				} else if (map[row][col] == 0) {
					cntBaby++;
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] tomato = queue.poll();
			map[tomato[0]][tomato[1]] = 1;

			for (int i = 0; i < 4; i++) {
				int nrow = tomato[0] + dir_row[i];
				int ncol = tomato[1] + dir_col[i];

				if (0 <= nrow && nrow < N && 0 <= ncol && ncol < M && map[nrow][ncol] == 0) { // 토마토가 있을 때
					if (day[nrow][ncol] > 0)
						continue;
					day[nrow][ncol] = tomato[2] + 1;
					if (min < day[nrow][ncol]) {
						min = day[nrow][ncol];
					}
					cntBaby--;
					queue.offer(new int[] { nrow, ncol, tomato[2] + 1 });
				}
			}

		} // end of while

		System.out.println(cntBaby == 0 ? min : -1);
	}

}
