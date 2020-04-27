package dp.backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IntegerTriangle {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = 0, n = Integer.parseInt(br.readLine());
        int[][] dp = new int[501][501];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = br.read();
                System.out.println(dp[i][j]);
                if (j == 1) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
                
                if (i == n) {
                    max = Math.max(max,dp[i][j]);    
                }
                
            }
        }
        
        bw.write(max);
        
        br.close();
        bw.flush();
        bw.close();
        
        

    }

}
