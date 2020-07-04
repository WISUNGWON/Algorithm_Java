package swea.lever.three;

import java.util.Arrays;
import java.util.Scanner;

public class HanbinSpotMart {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, N, M;
        int ans;
        int[] arr;
        
        T = sc.nextInt();
        
        for (int i = 1; i <= T; i++) {
            N = sc.nextInt();
            M = sc.nextInt();
            arr = new int[N];
            ans = 0;
            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }
            
            Arrays.sort(arr);
            
            for (int j = N - 1; j >= 0; j--) {
               if (arr[j] < M) {
                   for (int z = j - 1; z >= 0; z--) {
                       if (arr[j] + arr[z] <= M) {
                           ans = arr[j] + arr[z];
                       }
                   }
               }
            }
            
            if (ans == 0) {
                ans = -1;
            }
            
            System.out.println("#" + i + " " + ans);
        }

    }

}
