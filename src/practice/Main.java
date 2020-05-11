package practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        
        while (t != 0) {
            int r = sc.nextInt();
            String s = sc.next();
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < r; j++) {
                    System.out.print(s.substring(i, i + 1));
                }
            }
            System.out.println();
            t--;
        }
        
       
        sc.close();
        

    }

}
