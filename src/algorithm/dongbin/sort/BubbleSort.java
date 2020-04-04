package algorithm.dongbin.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        
        int temp;
        int[] arr = {1, 5, 10, 9, 8, 2, 4, 6, 3, 7};
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        
        System.out.println(Arrays.toString(arr));

    }

}
