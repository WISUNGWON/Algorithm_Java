package practice;

import java.util.Scanner;

public class DedcimalToBinary {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        to_bin(n);
        System.out.println();
        
        sc.close();
        
        
    }
    
    public static int to_bin(int n) {
        
        if (n == 0 || n == 1) {
            System.out.printf("%d", n);
        }
        else{
            to_bin(n / 2);
            System.out.printf("%d", n % 2);
        }
        
        return 0;
    }

}
