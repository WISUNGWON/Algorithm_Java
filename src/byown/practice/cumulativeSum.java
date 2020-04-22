package byown.practice;

// 누적합 기본 개념
import java.util.Scanner;

public class cumulativeSum {
    
    static Scanner sc = new Scanner(System.in);
    
    static int[] arr = new int[11];
    static int[] psum = new int[11];
    
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            arr[i] = i;
            psum[i] = psum[i - 1] + arr[i];
        }
        while(true) {
            System.out.println("INPUT A TO B");
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println("a : " + a + "  b : " + b);
            System.out.println("A ~ B sum: " + (psum[b] - psum[a - 1]));
        }
        

    }

}
