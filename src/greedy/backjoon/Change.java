package greedy.backjoon;

import java.util.Scanner;

//5585 Backjoon
public class Change {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int result = 0;
        int money = sc.nextInt();
        int change = 1000 - money;
        
        result += change / 500;
        change = change % 500;
        

        result += change / 100;
        change = change % 100;
        

        result += change / 50;
        change = change % 50;
        

        result += change / 10;
        change = change % 10;
        

        result += change / 5;
        change = change % 5;
        

        result += change / 1;
        change = change % 1;
        
        System.out.println(result);
        

    }

}
