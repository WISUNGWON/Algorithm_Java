package algorithm.dongbin.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        
        int temp, index = 0, min;
        int[] arr = {1, 5, 10, 9, 8, 2, 4, 6, 3, 7};
        
        
        for (int i = 0; i < arr.length; i++) {
            min = 9999;
            for (int j = i; j < arr.length; j++)
            if (min > arr[j]) {
                min = arr[j];
                index = j;
            }
            
            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        
        System.out.println(Arrays.toString(arr));
        
    }

}
