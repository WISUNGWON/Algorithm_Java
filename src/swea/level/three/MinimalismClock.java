package swea.lever.three;

import java.util.Scanner;

// 미니멀리즘 시계 SWEA 9997
public class MinimalismClock {
    
    static int test;
    static int angle;
    static int h, m;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        test = sc.nextInt();
        
        int i = 0;
        while (i < test) {
            angle = sc.nextInt();
            h = angle / 30;
            m = angle % 30 * 2;
            i++;
            System.out.println("#" + i + " " + h + " " + m);
        }
        
        sc.close();
    }

}
