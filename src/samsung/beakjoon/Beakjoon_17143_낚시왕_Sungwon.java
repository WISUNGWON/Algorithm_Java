package samsung.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon_17143_낚시왕_Sungwon {
	
	private static int R, C, M, ans;
	private static Shark[][] map;
	private static Shark[][] copiedMap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int rCycle = 0;
		int cCycle = 0;
		map = new Shark[R][C];
		copiedMap = new Shark[R][C];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1; 
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()); 
			int z = Integer.parseInt(st.nextToken());
			rCycle = 2 * (R - 1);
			cCycle = 2 * (C - 1);
			s %= (d <= 2 ? rCycle : cCycle);
			map[r][c] = new Shark(s, d, z);
		} // ----------------- 입력부 ----------------
		
//		낚시왕이 오른쪽으로 한 칸 이동한다.
		for (int i = 0; i < C; i++) {
//		낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
			fish(i);
//		상어가 이동한다.
			moveShark();
		}
		
		System.out.println(ans);
		
	} // end of main

	private static void moveShark() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != null) {
					int nr = i, nc = j, nd = map[i][j].dir;
					int s = map[i][j].speed;
					switch (nd) { // 1 2 3 4 위 아래 오른쪽 왼쪽
					case 1:
						if (s <= i) {
							nr -= s;
						} else if (s < i + C) {
							nr = s - i;
							nd = 2;
						} else {
							nr = s - C;
						}
						break;
					case 2:
						
						break;
					case 3:
						
						break;
					case 4:
						
						break;
					}
					Shark curS = new Shark(s, nd, map[i][j].size);
					if (copiedMap[nr][nc] != null) {
						// 집어넣을 상어와 들어있는 상어 크기 비교후 넣어주기
					}
				} // end of move
			}
		}
		// copiedMap의 내용들 Map에 넣어주기 (그리고 copiedMap은 ) 다시 원복
	}

	private static void fish(int col) {
		for (int i = 0; i < R; i++) {
			if(map[col][i] != null) {
				ans += map[col][i].size;
				map[col][i] = null;
				break;
			}
		}
	}
} // end of class

class Shark {
	int speed;
	int dir; // 1 2 3 4 위 아래 오른쪽 왼쪽
	int size;
	
	public Shark(int speed, int dir, int size) {
		super();
		this.speed = speed;
		this.dir = dir;
		this.size = size;
	}
	
}
