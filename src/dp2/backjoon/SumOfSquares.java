package dp2.backjoon;

// 1699 Á¦°ö¼öÀÇ ÇÕ
import java.util.Scanner;

public class SumOfSquares {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[100001];
        
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (dp[i] > dp[i - j * j] + 1 || dp[i] == 0) {
                    dp[i] = dp[i - j * j] + 1;
                }
            }
        }
        System.out.println(dp[n]);
        
        
        
        
    }
}
