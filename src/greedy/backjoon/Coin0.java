package greedy.backjoon;

import java.util.Scanner;

public class Coin0 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int result = 0;
        int n = sc.nextInt();
        int k = sc.nextInt();
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
