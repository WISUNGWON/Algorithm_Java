package dfs.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Beakjoon_1012 {
    
    static int[][] map;
    static boolean[][] isVisited;
    static int M, N, K, ans;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            ans = 0;
            map = new int[N][M];
            isVisited = new boolean[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());
                map[row][col] = 1;
            }
            
//            System.out.println();
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
            
           
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!isVisited[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                    }
                }
            }
            
            sb.append(ans).append("\n");
        } // end of test_case
        System.out.println(sb);
    } // end of main
    static int[] dr = {-1, 1, 0 , 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1};
    private static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[] {row, col});
        isVisited[row][col] = true;
        while(!q.isEmpty()) {
          int[] arr = q.poll();
          for (int i = 0; i < dr.length; i++) {
          int nr = arr[0] + dr[i];
          int nc = arr[1] + dc[i];
              if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1 && !isVisited[nr][nc]) {
                  q.offer(new int[] {nr, nc});
                  isVisited[nr][nc] = true;
              }
          }
        }
        ans++;
    }
//    private static void dfs(int row, int col) {
//        boolean isLast = true;
//        for (int i = 0; i < dr.length; i++) {
//            int nr = row + dr[i];
//            int nc = col + dc[i];
//            if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1 && !isVisited[nr][nc]) {
//                isVisited[nr][nc] = true;
//                dfs(nr, nc);
//                isLast = false;
//            }
//        }
//        if (isLast) {
//            ans++;
//        }
//    }
} // end of class
