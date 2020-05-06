package dp2.backjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//12865 평범한 배낭
public class NomalBag {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[][] arr = new int[n][2]; // 물건, 가치를 저정하는 배열
        
        // 물건과 가치 배열에 담기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //물건을 기준으로 배열 
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0]) {
                    return -1;
                }
                else if (a[0] > b[0]) {
                    return 1;
                }
                return 0;
            }
        });
        
        int vMax = 0;

        if (n == 1) {
            vMax = arr[0][1];
            if (k < arr[0][0]) {
                vMax = 0;
            }
        }
       
        for (int i = 0; i < n; i++) {
            int w = arr[i][0];
            int v = arr[i][1];
            for (int j = i; j < n; j++) {
                if (k >= w) {
                   v += arr[j][0];
                }
                k -= w;
            }
            
            if (v > vMax) {
                vMax = v;
            }
        }
        
        
        System.out.println(vMax);
        sc.close();

    }

}
