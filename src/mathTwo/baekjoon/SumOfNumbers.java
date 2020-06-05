package mathTwo.baekjoon;

import java.util.Scanner;

// 1024 ������ �� 
public class SumOfNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int L = sc.nextInt(); // ���ӵ� �ڸ��� 
        int t, x = -1, iter = -1; //x = ������. t = ���������κ��� ���ӵɶ� ���ϴ� ������ ��
        
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
