package dp.backjoon;

import java.util.Scanner;

public class Fibonacci2 {
    
    static long[] sumArr = new long[91];
    
    static long fib(int n) {
       if (n == 1 || n == 2) {
           return 1;
        } 
       if (sumArr[n] != 0) {
           return sumArr[n];
       }
       return sumArr[n] = fib(n - 1) + fib(n - 2); 
    }
    
    static long fib2(int n) {
        long f1 = 1, f2 = 1, f3 = 2;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            
            f1 = f2;
            
            f2 = f3;
        }
        return f3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        System.out.println(fib2(n));
        

    }

}
