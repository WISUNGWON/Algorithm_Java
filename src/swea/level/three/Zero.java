package swea.lever.three;

import java.util.Arrays;
import java.util.Scanner;

// 8931. 제로
public class Zero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T, K, ans;
        int[] arr;
        T = sc.nextInt();
        
        for (int i = 1; i <= T; i++) {
            K = sc.nextInt();
            arr = new int[K];
            ans = 0;
            int index = -1; // 값이 있는지 없는지
            for (int j = 0; j < K; j++) {
                int num = sc.nextInt();
                if (num != 0) {
                    index++;
                    arr[index] = num;
                    System.out.println(Arrays.toString(arr));
                    System.out.println("index : " + index);
                }
                if (num == 0) {
                    arr[index] = 0;
                    index--;
                    System.out.println(Arrays.toString(arr));
                    System.out.println("index : " + index);
                }
                
            }
            
            for (int z = 0; z < index + 1; z++) {
                ans += arr[z];
            }
            
            System.out.println("#" + i + " " + ans);
        }

    }

}
