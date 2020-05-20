package practice;

import java.util.Scanner;

public class Main {
    
    static int n, k;
    static int dp[][], w[], v[];

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        
        dp = new int[n + 1][k + 1];
        w = new int[n + 1]; //물건
        v = new int[n + 1]; // 가치
        
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - w[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        
        System.out.println(dp[n][k]);
        
    }

}
