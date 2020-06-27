package swea.lever.three;

import java.util.Scanner;

// [S/W 문제해결 기본] 1일차 - View
public class View {
    
    static int ans;
    static int testNum;
    static int[] arr;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int i = 0;
        while (i < 10) {
            testNum = sc.nextInt();
            arr = new int[testNum + 1];
            for (int j = 1; j < arr.length; j++) {
                arr[j] = sc.nextInt();
            }
            
            if (arr[1] > arr[2] && arr[1] > arr[3]) {
                ans += arr[1] - Math.max(arr[2], arr[3]);
            }
            if (arr[2] > arr[3] && arr[2] > arr[4] && arr[2] > arr[1]) {
                ans += Math.min((arr[2] - Math.max(arr[3], arr[4])), (arr[2] - arr[1]));
            }
            
            for (int j = 3; j < arr.length - 2; j++) {
                if ((arr[j] > arr[j - 2] && arr[j] > arr[j - 1]) && (arr[j] > arr[j + 1] && arr[j] > arr[j + 2])) {
                    ans += Math.min((arr[j] - Math.max(arr[j - 2], arr[j - 1])), (arr[j] - Math.max(arr[j + 1], arr[j + 2])));
                }
            }
            
            if (arr[arr.length - 2] > arr[arr.length - 3] && arr[arr.length - 2] > arr[arr.length - 4]) {
                ans += arr[arr.length - 2] - Math.max(arr[arr.length - 3], arr[arr.length - 4]);
            }
            if (arr[arr.length - 3] > arr[arr.length - 4] && arr[arr.length - 3] > arr[arr.length - 5] && arr[arr.length - 3] > arr[arr.length - 2]) {
                ans += Math.min((arr[arr.length - 3] - Math.max(arr[arr.length - 4], arr[arr.length - 5])), (arr[arr.length - 3] - arr[arr.length - 2]));
            }
            
            i++;
            System.out.println("#" + i + " " + ans);
            
        }
 
   }
}
