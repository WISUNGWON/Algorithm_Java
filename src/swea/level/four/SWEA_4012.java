package swea.level.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_4012 {
     
    static int[] numbers;
    static int food;
    static int N;
    static int[][] map;
    static boolean[] isSelected;
    private static int ans;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            } // ------------ 입력부---------------
            
            // ------------ 핵심 알고리즘 ---------------------
            Deque<int[]> qA = new ArrayDeque<int[]>(); 
            numbers = new int[N / 2];
            ans = Integer.MAX_VALUE;
            isSelected = new boolean[N + 1];
            combi(0, 1, qA);
            int size = qA.size();
            for (int i = 0; i < size / 2; i++) {
                int[] a = qA.pollFirst(); // N / 2 크기의 재료 존재
                int[] b = qA.pollLast(); //12(A) 34(B)
                // a, b재료끼리 순열 시행
                isSelected = new boolean[N + 1];
                numbers = new int[2];
                perm(0, a);
                int foodA = food;
                food = 0;
                perm(0, b);
                int foodB = food;
                food = 0;
                if (ans > Math.abs(foodA - foodB)) {
                    ans = Math.abs(foodA - foodB);
                }
            }
            // foodA랑 foodB가 달라야돼
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        } // end of tc
        System.out.println(sb);
    } // 메인 끝
 
    private static void perm(int cnt, int[] arr) {
        if (cnt == 2) {
            // 나온 순열 조합으로 음식 값 만들기
            food += map[numbers[0]][numbers[1]];
            return;
        }
        for (int i = 0; i < N / 2; i++) {
            if (isSelected[i]) {
                continue;
            }
            numbers[cnt] = arr[i];
            isSelected[i] = true;
            perm(cnt + 1, arr);
            isSelected[i] = false;
        }
    }
 
    private static void combi(int cnt, int n, Deque qA) {
        if (cnt == N / 2) { 
            // 절반씩 큐에 담기
            int[] cur = numbers.clone(); // 그냥 numbers를 넣어주면 static으로 인해 계속 값이 바뀐다 clone으로 넣어주어야 함.
            qA.add(cur);
            return;
        } else {
            for (int i = n; i <= N; i++) {
                numbers[cnt] = i;
                isSelected[i] = true;
                combi(cnt + 1, i + 1, qA);
                isSelected[i] = false;
            }
        }
    }
} // 클래스 끝