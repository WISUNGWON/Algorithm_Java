package dp2.backjoon;

import java.util.Scanner;

public class MakingOne {
    
    static int[] dp;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1];
        
        System.out.println(dp3(n));
        System.out.println(dp2(n));
        sc.close();
    
    }
    static int dp2(int n) {
        if (n == 1) {
            return 0;
        }
        if (dp[n] > 0) {
            return dp[n];
        }
        dp[n] = dp[n - 1] + 1;
        if (n % 2 == 0) {
            int temp = dp[n / 2] + 1;
            if (dp[n] > temp) {
                dp[n] = temp;
            }
        }
        
        if (n % 3 == 0) {
            int temp = dp[n / 3] + 1;
            if (dp[n] > temp) {
                dp[n] = temp;
            }
        }
        
        return dp[n];
    }
    
    static int dp3(int n) {
        for (int i = 2; i <= n; i++) {
            
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0) {
                int temp = dp[i / 3] + 1;
                if (dp[i] > temp) {
                    dp[i] = temp;
                }
            }
            if (i % 2 == 0) {
                int temp = dp[i / 2] + 1;
                if (dp[i] > temp) {
                    dp[i] = temp;
                }
                
            }        
       }
        return dp[n];
    }
} 