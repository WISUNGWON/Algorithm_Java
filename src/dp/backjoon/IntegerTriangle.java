package dp.backjoon;

import java.io.IOException;
import java.util.Scanner;

public class IntegerTriangle {

    public static void main(String[] args) throws IOException {
        
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int max = 0, n = sc.nextInt();
        int[][] dp = new int[501][501];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = sc.nextInt();
                
                if (j == 1) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
                
                max = Math.max(max,dp[i][j]);
            }
        }
        System.out.println(max);
        
        sc.close();

    }

}
