package array.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Average {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int score = 0;
        float maxScore = 0;
        float newScore;
        float total = 0;
        
        int[] arrScore = new int[n];
      
        
        for (int i = 0; i < n; i++) {
            score = sc.nextInt();
            arrScore[i] = score;
            
            if (score > maxScore) {
                maxScore = score;
            }
        }
        
        System.out.println(maxScore);
   
        
        for (int i = 0; i < n; i++) {
            newScore = arrScore[i] / maxScore * 100;
            System.out.println("new Score : " + newScore);
            total = total + newScore;
        }
        
        System.out.println(total);
        
        System.out.println(total / n);

    }
    
    public static void solution2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = 0;
        int max = 0;
        int score;
        
        for (int i = 0; i < n; i++) {
            score = sc.nextInt();
            total += score;
            if (score > max) {
                max = score;
            }
        }
        sc.close();
        
        double avg = 0;
        avg = 100.0 * total / max / n;
        System.out.printf("%.2f", avg);
    }

}
