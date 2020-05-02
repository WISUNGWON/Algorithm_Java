package dp2.backjoon;

import java.util.Scanner;

// 11053 가장 긴 증가하는 부분 수열
public class Progression2 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        
        int[][] dp = new int[1001][3];
        
        for (int i = 1; i <= n; i++) {
            dp[i][0] = sc.nextInt();
            dp[i][1] = 1; dp[i][2] = 1;
            for (int j = 1; j < i; j++) {
                if (dp[i][0] > dp[j][0] && dp[j][1] >= dp[i][1]) {
                    dp[i][1]++;
                }
                if (dp[i][0] < dp[j][0]) {
                    dp[i][2] = Math.max(dp[i][2], dp[j][2] + 1);
                    dp[i][2] = Math.max(dp[i][2], dp[j][1] + 1);
                }
            }
            
            max = Math.max(max, Math.max(dp[i][1], dp[i][2]));
        }
        
        System.out.println(max);
    }

}
