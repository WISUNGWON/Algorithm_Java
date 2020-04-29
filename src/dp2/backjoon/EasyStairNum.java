package dp2.backjoon;

import java.util.Scanner;

public class EasyStairNum {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        int N;
        int[][] dp = new int[101][12];
        N = sc.nextInt();
        
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= 10; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }
        
        for (int i = 1; i <= 10; i++) {
            ans = (ans + dp[N][i]) % 1000000000;
        }
        
        System.out.printf("%d\n", ans);
        
        sc.close();
        

    }

}
