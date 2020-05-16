package practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
       
        int result = 0;
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arrCoin = new int[n];
        
        for (int i = 0; i < n; i++) {
            arrCoin[i] = sc.nextInt();
        }
        
        for (int i = n - 1; i >= 0; i--) {
            result += k / arrCoin[i];
            k = k % arrCoin[i];
        }
        
        System.out.println(result);
        
        
        
        

    }

}
