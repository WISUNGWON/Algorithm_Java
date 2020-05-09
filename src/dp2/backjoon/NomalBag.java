package dp2.backjoon;

import java.util.*;

public class NomalBag {
    static int n, k;
    static int dp[][], w[], v[];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        
        dp = new int[n + 1][k + 1];
        w = new int[n + 1];
        v = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        
        for (int i = 1; i <= n; i++) { //i는 item
            for (int j = 1; j <= k; j++) { // j는 물건의 무게
                dp[i][j] = dp[i - 1][j];
                if (j - w[i] >= 0) { // >= (=를 꼭 해야함)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            } 
        }
        
        System.out.println(dp[n][k]);
    }
}
