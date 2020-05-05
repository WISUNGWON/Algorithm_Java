package dp2.backjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 2565 ภüฑ๊มู
public class Wire {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n + 1][2];
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0]) {
                    return -1;
                }
                else if (a[0] > b[0]) {
                    return 1;
                }
                return 0;
            }
            
            
        });

        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i][1] > arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
              
            }
        }
        
        int max = 0;
        for (int j = 1; j <= n; j++) {
            if (dp[j] > max) {
                max = dp[j];
            }
        }

        System.out.println(n - max);
        sc.close();
    }

}
