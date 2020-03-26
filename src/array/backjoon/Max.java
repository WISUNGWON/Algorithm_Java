package array.backjoon;

import java.util.Scanner;

public class Max {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int[] arr = new int[9];
        
        int max = -100;
        int maxNum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            
            if (max < arr[i]) {
                max = arr[i];
                maxNum = i + 1;
            }
        }
        System.out.println(max);
        System.out.println(maxNum);
        

    }

}
