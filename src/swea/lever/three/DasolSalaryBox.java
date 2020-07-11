package swea.lever.three;

import java.util.Scanner;

public class DasolSalaryBox {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        int T, N, x;
        float sum, p;
        
        T = sc.nextInt();
        for(int i = 1; i <= T; i++) {
            N = sc.nextInt();
            sum = 0;
            for(i = 0; i < N; i++) {
                p = sc.nextFloat();
                x = sc.nextInt();
                sum += p * x;
            }
            System.out.format("#%d %f\n", T, sum);
        }
        sc.close();
    }
    
}
