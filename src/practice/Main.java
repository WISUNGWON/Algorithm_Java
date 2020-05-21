package practice;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {    
                
            Scanner sc = new Scanner(System.in);
            int jump = 0, noJump = 0;
            int n = sc.nextInt();
            int[] stairs = new int[301];
            int[] dp = new int[301];
            
            for (int i = 1; i <= n; i++) {
                stairs[i] = sc.nextInt();
                
            }
            
            dp[1] = stairs[1];
            dp[2] = stairs[1] + stairs[2];
            
            for (int i = 3; i <= n; i++) {
                noJump = stairs[i] + stairs[i - 1] + dp[i - 3];
                jump = stairs[i] + dp[i - 2];
                
                dp[i] = Math.max(noJump, jump);
            }
            
            System.out.println(dp[n]);
        
    }

}
