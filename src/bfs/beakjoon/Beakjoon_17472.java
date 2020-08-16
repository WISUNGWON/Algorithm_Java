package bfs.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
public class Beakjoon_17472 {
    static int N, M;
    private static int[][] map;
    private static boolean[][] isVisited, isBridge;
    private static int landNum; // 섬의 고유 번호
    private static int bLen, bAns, bNum; // 다리 길이 및 총 다리 길이, 만들어진 다리 개수
    private static int[] parents, rank;
    private static PriorityQueue<Bridge> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // row
        M = Integer.parseInt(st.nextToken()); // col
        map = new int[N][M];
        isVisited = new boolean[N][M];
        landNum = 2;
        pq = new PriorityQueue<Bridge>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 섬 각각 구별하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    markLandBfs(i, j);
                }
            }
        }
        isVisited = new boolean[N][M]; // makeBridge에서 쓸 방문 초기화
        isBridge = new boolean[landNum][landNum]; // landNum은 마지막 섬의 고유번호 + 1 따라서 인덱스를 방문 체크로 사용
         //다리 길이 카운트 
        // 다리 설치하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !isVisited[i][j]) { // 섬이고 방문하지 않았으면 다리 설치 진행
                    for (int dir = 0; dir < dc.length; dir++) {
                        int nr = i + dr[dir];
                        int nc = j + dc[dir];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                            bLen = 0;
                            makeBridgeDfs(i, j, dir, map[i][j]);
                        }
                    }
                }
            }
        }
        
      System.out.println(landNum);
      
      for (int i = 0; i < N; i++) {
          for (int j = 0; j < M; j++) {
              System.out.print(map[i][j] +  " ");
          }
          System.out.println();
      }
        System.out.println(countMinBridge());
    } // end of main
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1}; // 상하좌우
    /** */
    private static void makeBridgeDfs(int row, int col, int dir, int start) {   // 지정된 방향이 있다면 그 방향으로만 Dfs
        int nr = row + dr[dir];
        int nc = col + dc[dir];
        if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
            bLen++;
            makeBridgeDfs(nr, nc, dir, start);
        } else if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0 && bLen >= 2 && !isBridge[start][map[nr][nc]]) { // 다른 섬 도착
            bNum++;
            isBridge[start][map[nr][nc]] = true;
            isBridge[map[nr][nc]][start] = true;
            pq.add(new Bridge(start, map[nr][nc], bLen)); // 만들어진 다리 정보 저장
            return;
        } else {
            return;
        }
    }
     /** 섬을 각각 구별해주는 메서드 (2, 3, 4 ...) */
    private static void markLandBfs(int row, int col) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[] {row, col});
        isVisited[row][col] = true;
        boolean isOnlyOne = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < dr.length; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1) {
                    map[nr][nc] = landNum;
                    q.offer(new int[] {nr, nc});
                    isOnlyOne = false;
                    isVisited[nr][nc] = true;
                }
            }
        }
        if (isOnlyOne) {
            map[row][col] = landNum;
        }
        landNum++;
    }
    /** */
    private static int countMinBridge () { // 크루스칼 알고리즘 사용해서 최소 간선 찾은 후 답 출력
        parents = new int[landNum];
        rank = new int[landNum];
        for (int i = 2; i < landNum; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < bNum; i++) {
            Bridge b = pq.poll(); // 다리가 짧은 개수를 우선적으로 뺌
            int start = b.s;
            int end = b.e;
            if (findSet(start) == findSet(end)) { // 사이클이 생기면 넘어감
                continue;
            }
            unionSet (start, end);
            bAns += b.v;
        }
        if (bAns == 0) {
            return -1;
        }
        return bAns;
    }
    /** */
    private static int findSet (int i) {
        if (parents[i] == i) {
            return i;
        } else {
            return parents[i] = findSet(parents[i]);
        }
    }
    /** */
    private static void unionSet (int i, int j) {
        i = findSet(i);
        j = findSet(j);
        if (i == j) {
            return;
        }
        if (rank[i] < rank[j]) {
            parents[i] = j;
        } else {
            parents[j] = i;
            if (rank[i] == rank[j]) {
                rank[i]++;
            }
        }
    }
} // end of class
/** */
class Bridge implements Comparable<Bridge> {
    int s, e, v;
    public Bridge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
    public int compareTo(Bridge b) { // 다리의 크기에 따라 오름차순 정렬
        return b.v >= this.v ? -1 : 1;
    }
}
