package dp2.backjoon;

import java.util.Scanner;

public class PuttingInABox {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int[] a = new int[1001];
        int[] dp = new int[1001];
        int n = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        
        dp[1] = 1;
        
        int max = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (a[i] > a[j] && dp[j] >= dp[i]) {
                    dp[i]++;
                }
            }
            
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        
        System.out.println(max);
        sc.close();
    }

}
