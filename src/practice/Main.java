package practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt();
        int margin = C - B;
        
        if (margin > 0) {
            System.out.println((A / margin) + 1);
        } else {
            System.out.println(-1);
        }
        
        
        sc.close();
    }

}
