package greedy.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Scale {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int target = 1;
        int n = sc.nextInt();
        int[] weights = new int[1001];

        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        
        Arrays.sort(weights, 0, n);
        
        for (int i = 0; i < n; i++) {
            if (weights[i] > target) {
                break;
            }
            
            target += weights[i];
        }
        
        System.out.println(target);
    }

}
