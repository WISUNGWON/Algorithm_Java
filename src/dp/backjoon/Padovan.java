package dp.backjoon;

import java.util.Scanner;

// 9461 파도반수열
public class Padovan {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            long result = 0;
            if (n == 1 || n == 2 || n == 3) {
                result = 1;
            }
            else if (n == 4 || n == 5) {
                result = 2;
            } else {
                for (int i = 6; i <= n; i++) {
                    arr[i] = arr[i - 1] + arr[i - 5];
                }
                result = arr[n];
            }
            
            System.out.println(result);
        }

    }

}
