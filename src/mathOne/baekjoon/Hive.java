package mathOne.baekjoon;

import java.util.Scanner;

// 2292 ���� ���� 
public class Hive {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
//        for (int i = 1; i <= 20000; i++) { // �� Ǯ��
//            if (n <= 3 * i * (i - 1) + 1) {
//                System.out.println(i);
//                break;
//            }
//        }
        solution2(n);
        
        sc.close();

    }
    
    static public void solution2(int n) {
        int sum = 1, i = 0;
        for (; sum < n; i++) {
            sum += 6 * (i + 1); //���������� ����
            System.out.println("this is sum : " + sum);
        }
        System.out.println(i + 1);
    }

}
