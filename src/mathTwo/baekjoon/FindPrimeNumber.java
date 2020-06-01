package mathTwo.baekjoon;

import java.util.Scanner;

public class FindPrimeNumber {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int count = 0;
        int cnt2 = 1;
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == 2) {
                count++;
            }
            
            if (arr[i] % 2 == 1 && arr[i] > 2) {
                for (int j = 3; j < arr[i]; j += 2) {
                    if (arr[i] % i != 0) {
                        cnt2 = 0;
                        System.out.println(arr[i]);
                    }
                }
                if (cnt2 == 0) {
                    count++;
                }
            }
        }
        
        System.out.println(count);
        

    }

}
