package greedy.backjoon;

import java.util.Scanner;

public class SickNight {

    static long n, m;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextLong();
        m = sc.nextLong();
        
        if (n == 1) {
            System.out.println(1);
        }
        else if (n == 2) {
            if ((m + 1) / 2 > 4) {
                System.out.println(4);
            }
            else {
                System.out.println((m + 1) / 2);
            }
        }
        else {
            if (m >= 7) {
                System.out.println(m - 2);
            }
            else {
                System.out.println(Math.min(m, 4));
            }
        }
        
        
        sc.close();

    }

}
