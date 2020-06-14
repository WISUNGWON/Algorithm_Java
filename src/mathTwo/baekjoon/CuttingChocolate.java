package mathTwo.baekjoon;

// 2163 초콜릿 자르기
import java.util.Scanner;

public class CuttingChocolate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        System.out.println((m - 1) + (n - 1) * m);
        
        sc.close();

    }

}
