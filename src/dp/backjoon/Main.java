package dp.backjoon;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        long[][] arr = new long[1001][3];
        long[][] dp = new long[1001][3];
        long min = 0;
        int n = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {
            arr[i][0] = sc.nextLong();
            arr[i][1] = sc.nextLong();
            arr[i][2] = sc.nextLong();
        }
        
        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        dp[1][2] = arr[1][2];
        
        for (int i = 2; i <= n; i++) {
            dp[i][0] = arr[i][0] + (Math.min(dp[i - 1][2], dp[i - 1][1]));
            dp[i][1] = arr[i][1] + (Math.min(dp[i - 1][0], dp[i - 1][2]));
            dp[i][2] = arr[i][2] + (Math.min(dp[i - 1][0], dp[i - 1][1]));
        }
        
        min = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
        System.out.println(min);
        
        sc.close();

    }

}
