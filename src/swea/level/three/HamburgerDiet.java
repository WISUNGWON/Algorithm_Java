package swea.level.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 5215. 햄버거 다이어트
public class HamburgerDiet {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int test, N, L;
        int[][] dp;
        int[] arrT, arrK;
        String[] arr;
        
        test = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= test; i++) {
            arr = br.readLine().split(" ");
            N = Integer.parseInt(arr[0]); // 개수
            L = Integer.parseInt(arr[1]); //칼로리 최대 
            dp = new int[N + 1][L + 1];
            arrT = new int[N + 1]; // 점수 배열
            arrK = new int[N + 1]; // 칼로리 배열
            for (int j = 1; j <= N; j++) {
                arr = br.readLine().split(" ");
                arrT[j] = Integer.parseInt(arr[0]);
                arrK[j] = Integer.parseInt(arr[1]);
            }
            for (int j = 1; j <= N; j++) {
                for (int z = 1; z <= L; z++) {
                    dp[j][z] = dp[j - 1][z];
                    if (z - arrK[j] >= 0) {
                        dp[j][z] = Math.max(dp[j - 1][z], dp[j - 1][z - arrK[j]] + arrT[j]);
                    }
                }
            }
            
            bw.write("#" + i + " " + dp[N][L] + "\n");
            
        }
        
        br.close();
        bw.flush();
        bw.close();

    }

}
