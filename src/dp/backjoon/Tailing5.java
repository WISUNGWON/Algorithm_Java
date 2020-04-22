package dp.backjoon;
// 14852 타일채우기 3 - 1차원 배열 2개로풀기

import java.util.Scanner;

public class Tailing5 {
    static final long MOD = 1000000007;
    
    static long[] dp = new long[1000001];
    static long[] sum = new long[1000001];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp[0] = 1; dp[1] = 2; dp[2] = 7;
        for (int i = 3; i <= n; i++) {
            sum[i] = (sum[i - 1] + dp[i - 3]) % MOD;
            dp[i] = (2 * dp[i - 1] + 3 * dp[i - 2] + 2 * sum[i]) % MOD;
        }
        
        System.out.println(dp[n]);
        sc.close();
    }
    

}
