package codility.practice;

import java.util.Scanner;

public class FrogJmp {
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int D = sc.nextInt();
        System.out.println(solution(X, Y, D));
    }
    public static int solution(int X, int Y, int D) {
        if ( X == Y){
            return 0;
        }
        
        if ((Y - X) % D == 0){
            return (Y - X) / D;
        } 
        else {
            return ((Y - X) / D) + 1;
        }
    }
}
