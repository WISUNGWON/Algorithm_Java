package dp2.backjoon;

import java.util.Scanner;

// 1660 ĸƾ �̴ټ�
public class CaptainLDS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[101];
        
        int k = 1;
        int j = k + 1;
        dp[1] = 1;
        
        while (n - dp[k] > dp[j]) {
            k++;
            j = k + 1;
            int a = ((int)Math.pow(k,2) + k) / 2;
            dp[k] = dp[k - 1] + a;
            System.out.println(dp[k]);
           
            
        }
        
        System.out.println(k);
        

    }

}
