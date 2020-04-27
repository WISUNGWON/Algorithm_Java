package dp2.backjoon;

import java.util.Scanner;

public class MakingOne {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        
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
        System.out.println(dp[n]);
        sc.close();
        

    }

}
