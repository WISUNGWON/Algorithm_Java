package all.backjoon;

import java.util.Scanner;

// 10872 ÆÑÅä¸®¾ó
public class Factorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        System.out.println(factorial(N));

    }
    
    public static int factorial(int N) {
        if (N == 0) {
           return 1;
        }
        
        return N * factorial(N - 1);
        
        
    }

}
