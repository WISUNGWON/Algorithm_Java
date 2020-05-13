package mathOne.baekjoon;

import java.util.Scanner;

public class ACMHotel {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        
        while (T != 0) {
            int H = sc.nextInt(), W = sc.nextInt(), N = sc.nextInt();
            int f; // Ãþ¼ö
            int e; // ¹æ ¹øÂ°
            if (N % H == 0) {
                f = H;
                e = N / H;
            } else {
                f = N % H;
                e = N / H + 1;
            }
            if (e >= 10) {
                System.out.println(f + "" + e);
            } else {
                System.out.println(f + "0" + e);
            }
            
            T--;
        }

    }

}
