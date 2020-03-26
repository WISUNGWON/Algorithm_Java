package array.backjoon;

import java.util.Scanner;

public class MaxMin {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int arrLen = sc.nextInt();
        
        int[] arr = new int[arrLen];
        
        int max = -1000000;
        int min = 1000000;
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println(min + " " + max);
        
    }


}
