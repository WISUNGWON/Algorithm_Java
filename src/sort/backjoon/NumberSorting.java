package sort.backjoon;

import java.util.Scanner;

public class NumberSorting {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        int index = 0, temp;
        int[] arr = new int[1001]; //문제에 주어진 배열의 최대 범위보다 1 큰 값.
        int number = sc.nextInt();
        
        for (int i = 0; i < number; i++){
            arr[i] = sc.nextInt();
        }
        
        sc.close();
        
        for (int i = 0; i < number; i++){
            int min = 1001; //문제에 주어진 최소값의 최대범위보다 1 큰 값.
            for (int j = i; j < number; j++){
                if (min > arr[j]){
                    min = arr[j];
                    index = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            
        }
        
        for (int i = 0; i < number; i++){
            System.out.println(arr[i]);
        }
        
    }

}
