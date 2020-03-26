package array.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class NumberCount {

    public static void main(String[] args) {
        
            
            Scanner sc = new Scanner(System.in);
            
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            
            int result = A * B * C;
            
            String resultS = Integer.toString(result);
            char[] arrC = resultS.toCharArray();
            
            int[] arr = new int[10];
            
            for (int i = 0; i < arr.length; i++){
                for (int j = 0; j < arrC.length; j++){
                    if (Character.forDigit(i, 10) == arrC[j] ){
                        arr[i]++;
                    }
                }
                System.out.println(arr[i]);
            }
            
        }

    

}
