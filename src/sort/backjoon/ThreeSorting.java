package sort.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeSorting {

    public static void main(String[] args) {
        
        int[] arr = new int[3];
        
        Scanner sc = new Scanner(System.in);
        
        int index = 0, temp;
        
        for (int i = 0; i < arr.length; i++) {
            int arrNum = sc.nextInt();
            if (arrNum < 1000001) {
                arr[i] = arrNum;
            } else {
                System.out.println("최소값은 : 1,000,000을 넘을 수 없습니다");
            }
        }
        
        System.out.println(Arrays.toString(arr));
        
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(" ");
            }
        }
        

    }

}
