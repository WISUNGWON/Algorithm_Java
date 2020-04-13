package algorithm.dongbin.all;

import java.util.Scanner;

//동전 나누기 알고리즘
public class GreedyExample {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int result = 0;
        int fiveH = 500, hundred = 100, ten = 10;
        int money = sc.nextInt();
        
        result += money / fiveH;
        money = money % fiveH;
        
        result += money / hundred;
        money = money % hundred;
        
        result += money / ten;
        money = money % ten;
        
        System.out.println(result);
        
        
        
        

    }

}
