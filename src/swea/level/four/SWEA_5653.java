package swea.level.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class SWEA_5653 {
    static final int REAL_INDEX = 400; // 초기 배양 정보를 가운데 넣기 위한 설정값 (맵의 크기에 따라 달라짐)
    static final int INF = 1000; // n*m == 2500 // 맵의 크기 ( 직접 계산 , 시간과 주어질 수 있는 초기 상태를 고려, 넉넉하게)
     
    static int[][] map;
    static boolean[][] visited;
     
    static PriorityQueue<Cell> pq;
    static Queue<Cell> q;
     
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int T, N, M, K;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
         
        T = Integer.parseInt(br.readLine());
         
        for(int test_case = 1 ; test_case <= T ; ++test_case) {
            st = new StringTokenizer(br.readLine());
             
            N = Integer.parseInt(st.nextToken()); // 세로크기 (row)
            M = Integer.parseInt(st.nextToken()); // 가로크기 (col)
            K = Integer.parseInt(st.nextToken()); // 배양시간
             
            q = new LinkedList<>();
            pq = new PriorityQueue<>();
            map = new int[INF][INF];
            visited = new boolean[INF][INF];
             
            for(int i = 0 ; i < N ; ++i) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < M ; ++j) {
                    int life = Integer.parseInt((st.nextToken()));
                    
                    if(life > 0) {
                        int x = REAL_INDEX + i;
                        int y = REAL_INDEX + j;
                        map[x][y] = life;
                        visited[x][y] = true;
                        q.add(new Cell(x, y, life, life, life * 2)); // 위치 (x, y), life, start(활성 시간), dead
      
                    }
                }
            }
             
            for(int time = 1 ; time <= K ; ++time) { // 타임만큼 돌면서 핵심 수행
                changeStatus(time);
                bfs(time);
            }
            sb.append("#").append(test_case).append(" ").append(q.size()).append("\n"); 
        }
        System.out.println(sb);
    }
     
     
     
    private static void bfs(int time) {
        while(!pq.isEmpty()) {
            Cell cell = pq.poll();
            if (time < cell.dead) { 
                q.add(cell);
            }
             
            for(int d = 0 ; d < 4 ; ++d) {
                int nx = cell.x + dr[d];
                int ny = cell.y + dc[d];
                 
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    map[nx][ny] = cell.life;
                    q.add(new Cell(nx, ny, cell.life,
                            time + cell.life,
                            time + cell.life * 2));
                }
            }
        }
    }
 
    private static void changeStatus(int time) {
        int qSize = q.size();
         
        for(int i = 0 ; i < qSize ; ++i) {
            Cell cell = q.poll();
             
            if(time <= cell.start) { // 비활성
                q.add(cell); // 도로 넣기
            } else if(time == cell.start + 1) { // 활성화
                pq.add(cell); // pq에 넣어 낮은 시간부터 처리 --> 최종적으로 life가 큰 것으로 업데이트 된다.
            } else if(time > cell.start && time < cell.dead) {
                q.add(cell); // 활성 후 1초가 지나고 아직 살아있는 상태
            }
             
        }
         
    }   
    static class Cell implements Comparable<Cell>{
        int x, y, life;
        int start, dead;
         
        public Cell(int x, int y, int lifecycle, int start, int dead) {
            this.x = x;
            this.y = y;
            this.life = lifecycle;
            this.start = start;
            this.dead = dead;
        }
 
        @Override
        public int compareTo(Cell o) {
            return  o.life - this.life; //생명력 오름차순 정렬 --> 최종적으로 life이 큰 것으로 업데이트 된다.
        }
    }
}