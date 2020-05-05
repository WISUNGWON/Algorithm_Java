package dp2.backjoon;

import java.util.Scanner;

// 11055 가장 큰 증가 부분 수열
public class Progression3 {
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1]; // 수열의 값 저장
        int[] dp = new int[n + 1]; // 해당 인덱스에서 가장 큰 증가 부분 수열 값 저장
        
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        
        dp[1] = a[1];
        
        int max = dp[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = a[i];
            for (int j = 1; j < i; j++) {
                if (a[i] > a[j] && dp[j] + a[i] > dp[i]) {
                    dp[i] = dp[j] + a[i];
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
