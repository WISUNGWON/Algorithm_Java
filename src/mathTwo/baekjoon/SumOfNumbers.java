package mathTwo.baekjoon;

import java.util.Scanner;

// 1024 수열의 합 
public class SumOfNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int L = sc.nextInt(); // 연속된 자리수 
        int t, x = -1, iter = -1; //x = 시작점. t = 시작점으로부터 연속될때 더하는 정수의 합
        
        for (int i = L; i <= 100; i++) {
            t = (i - 1) * i / 2;
            if ((N - t) % i == 0 && (N - t) / i >= 0) {
                x = (N - t) / i;
                iter = i;
                break;
            }
        }
        
        if (x == -1) {
            System.out.println(-1);
        }
        else {
            for (int i = 0; i < iter; i++) {
                System.out.print(x + i);
                System.out.print(' ');
            }
        }
        
        sc.close();

    }

}
