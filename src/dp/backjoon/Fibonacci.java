package dp.backjoon;

import java.util.Scanner;

public class Fibonacci {
    

    
    static String fib(int n) {
        int[] sumL = new int[41];
        int[] sumR = new int[41];
        sumL[0] = 1; 
        sumL[1] = 0;
        sumR[0] = 0;
        sumR[1] = 1;
        if (n == 0 || n == 1) {
            return (sumL[n] + " " + sumR[n]);
            
        } else {
            for (int i = 2; i <= n; i++) {
                sumL[i] = sumL[i - 1] + sumL[i - 2];
                sumR[i] = sumR[i - 1] + sumR[i - 2];
            }
            return (sumL[n] + " " + sumR[n]);
        }   
    }
    
    static String fib2(int n) {
        int[][] f = new int[41][2];
        f[0][0] = 1;
        f[1][1] = 1;
        for (int i = 2; i < 41; i++) {
            for(int j = 0; j < 2; j++) {
                f[i][j] = f[i - 1][j] + f[i -2][j];
            }
        }
        return (f[n][0]+ " " +f[n][1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(fib2(n));
            
        }
         
        sc.close();

    }

}
