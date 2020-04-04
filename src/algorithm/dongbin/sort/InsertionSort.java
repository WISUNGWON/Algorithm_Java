package algorithm.dongbin.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int temp;
        int[] arr = {1, 5, 10, 9, 8, 2, 4, 6, 3, 7};
        
        for (int i = 0; i < arr.length - 1; i++) {
            
            int j = i;
            System.out.println(j);
            while (arr[j] > arr[j + 1] && j > 0) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                System.out.println("실행 : " + j);
                j--;
            }
            
        }
      
        
        System.out.println(Arrays.toString(arr));
        
    }

}
