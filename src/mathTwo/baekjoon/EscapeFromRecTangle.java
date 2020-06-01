package mathTwo.baekjoon;

import java.util.Scanner;

// 1085번 직사각형에서의 탈출
public class EscapeFromRecTangle {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int x, y, w ,h, min;
        x = sc.nextInt();
        y = sc.nextInt();
        w = sc.nextInt();
        h = sc.nextInt();
        
        min = x;
        if (x > y) {
            min = y;
        } 
        if (min > w - x) {
            min = w - x;
        }
        if (min > h - y) {
            min = h - y;
        }
        
        System.out.println(min);
        
        

    }

}
