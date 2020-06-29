package swea.lever.three;

import java.util.Scanner;

// 10032 과자분배
public class SnackDistribution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int N, K, ans = 0;
        int i = 0;
        
        while (i < test) {
            N = sc.nextInt();
            K = sc.nextInt();
            if (N % K == 0) {
                ans = 0;
            }
            if (N % K != 0) {
                ans = 1;
            }
            i++;
            System.out.println("#" + i + " " + ans);
        }
        
        sc.close();
                

    }

}
