package mathOne.baekjoon;

import java.util.Scanner;

// 2869 달팽이는 올라가고 싶다.
public class ClimbSnail {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt(), b = sc.nextInt(), v = sc.nextInt();
        int count = 0;
        
        if (v == a) {
            System.out.println(1);
        } else {
            count = (int)Math.ceil((double)(v - a) / (a - b)) + 1;
            System.out.println(count);
        }
        
        sc.close();
    }

}
