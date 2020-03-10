package byown.practice;

import java.util.Scanner;

public class PrintStar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        
        star6(num);
        
        

    }
    
    public static void star1 (int A) {
        for (int i = 1; i <= A; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public static void star2 (int A) {

    }
    
    public static void star3 (int A) {
        for (int i = A; i >= 1; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public static void star4 (int A) {
        int n = 0;
        while (n < A) {
            for (int j = 0; j < n; j++) {
                System.out.print(" ");
            }
            
            for (int i = A; i > n; i--) {
                System.out.print("*");
            }
            
            System.out.println();
            n++;
        }
    }
    
    public static void star5 (int A) {
        int n = 1;
        while (n <= A) {
            for (int i = 1; i <= A - n; i++) {
                System.out.print(" ");
            }
            
            for (int j = 1; j <= 2*n - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
            n++;
        }
    }
    
    public static void star6 (int A) {
        int n = 1;
        while (n <= A) {
            for (int i = 1; i < n; i++) {
                System.out.print(" ");
            }
            
            for (int j = 1; j <= 2*(A - n + 1) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
            n++;
        }
    }
    
    public static void star7 (int A) {
        
        for (int i = 1; i <= 2 * A - 1; i++) {
            for (int j = A - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * k - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
    }
}
