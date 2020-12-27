package bfs.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beakjoon_18405_Sungwon {
	
	private static class e implements Comparable<e>{
		int num, x, y;
		public e(int num, int x, int y) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
		}
		
	   public int compareTo(e e1) {
	        return this.num - e1.num;
	    }
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<e> list = new ArrayList<e>();
		
		int[][] map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if (temp != 0) {
					list.add(new e(temp, i, j));
				}
			}
		}
		
		Collections.sort(list);
		Queue<e> q = new LinkedList<e>();
		for (int i = 0; i < list.size(); i++) {
			q.add(list.get(i));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int s = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		//solution
		int[] dr = {1, -1, 0, 0}; // 상하좌우
		int[] dc = {0, 0, -1, 1};// 상하좌우
		while(s-- > 0) {
			int size = q.size();
			while (size-- > 0) {
				e cur = q.poll();
				int num = cur.num;
				int row = cur.x;
				int col = cur.y;
				for (int i = 0; i < 4; i++) {
					int nr = row + dr[i];
					int nc = col + dc[i];
					if (nr > 0 && nr <= n && nc > 0 && nc <= n && map[nr][nc] == 0) {
						map[nr][nc] = num;
						q.add(new e(num, nr, nc));
					}
				}
			}
		}
		
		//answer
		System.out.println(map[x][y]);
	} // end of main
} // end of class
