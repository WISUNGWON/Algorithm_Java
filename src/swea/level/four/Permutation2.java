package swea.level.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Permutation2 {

    private static int N;
    private static int K;
    private static int[] numbers;
    private static boolean[] isVisited;
    private static List<int[]> arrs;
    private static int cnt;

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); // N개의 수열 생성
            K = Integer.parseInt(st.nextToken()); // 수열의 점수
            numbers = new int[N]; // 순열 저장 배열
            isVisited = new boolean[N + 1]; // 해당 숫자 방문했는지 체크 
            cnt = 0;
            arrs = new ArrayList<int[]>();
        }
        
        permutation(0);
        OrderedPairCheck();
        System.out.println(cnt);

    } // end of main
    
    public static void permutation (int cnt) {
        if (cnt == N) {
            // 기저에서 비교해서 카운트 까지 해야겠네
            arrs.add(numbers);
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (isVisited[i]) { // 해당 숫자 이미 방문했으면 continue
                continue;
            } 
            numbers[cnt] = i;
            isVisited[i] = true;
            permutation(cnt + 1);
            isVisited[i] = false;
        }
    }
   
    public static void OrderedPairCheck () {
        System.out.println(arrs.size() + "arrs size");
        int sum;
        for (int i = 0; i < arrs.size(); i++) {
            int[] p1 = arrs.get(1);
            System.out.println(Arrays.toString(p1));
            for (int j = 0; j < arrs.size(); j++) {
                int[] p2 = arrs.get(j);
                System.out.println(Arrays.toString(p2));
                sum = 0;
                for (int z = 0; z < N; z++) {
                    sum = sum + Math.max(p1[z], p2[z]);
                    
                }
                System.out.println(sum);
                if (sum >= K) {
                    cnt++;
                }
            }
        }
    }
} // end of class
