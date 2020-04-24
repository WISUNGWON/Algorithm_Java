package dp.backjoon;

import java.util.Scanner;

public class RGBdistance {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int[][] house = new int[1001][3]; // 각 집(i)의 빨강(0) 초록(1) 파랑(2) 비용을 2차원 배열에 저장.
        int[][] dp = new int[1001][3]; // 각 집을 칠할 때 색상별 최소비용을 dp 배열에 저장.
        int result = 0;
        int n = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {
            house[i][0] = sc.nextInt();
            house[i][1] = sc.nextInt();
            house[i][2] = sc.nextInt();
        }
        
        dp[1][0] = house[1][0]; // 첫 집을 칠할 때 색상별 최소 비용은 각 집의 색상별 비용 그 자체임.
        dp[1][1] = house[1][1];
        dp[1][2] = house[1][2];
        
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + house[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + house[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + house[i][2];
        }
        
        result = Math.min(dp[n][2], Math.min(dp[n][0], dp[n][1]));
        
        System.out.println(result);
        
        sc.close();
    }

}
