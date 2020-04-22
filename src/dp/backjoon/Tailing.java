package dp.backjoon;

import java.util.Scanner;

//11726 2xn Å¸ÀÏ¸µ
public class Tailing {
    
    static int[] tail = new int[1001];
    
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        System.out.println(tailing(n));
        
        sc.close();

    }
    
    public static int tailing(int n ) {
        if (n == 1) {
            return tail[n] = 1;
        }
        if (n == 2) {
            return tail[n] = 2;
        }
        if (tail[n] != 0 && n > 2) {
            return tail[n];
        }
        return  tail[n] = (tailing(n - 1) + tailing(n - 2)) % 10007;
    }

}
