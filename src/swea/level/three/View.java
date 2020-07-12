package swea.lever.three;

import java.util.Arrays;
import java.util.Scanner;

// [S/W 문제해결 기본] 1일차 - View
public class View {
    
    static int testNum;
    static int ans;
    static int[] arr;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int i = 0;
        while (i < 10) {
            testNum = sc.nextInt();
            ans = 0;
            arr = new int[testNum];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextInt();
            }
            
            for (int j = 2; j < arr.length - 2; j++) {
                int near[] = new int[4];
                near[0] = arr[j] - arr[j - 1];
                near[1] = arr[j] - arr[j - 2];
                near[2] = arr[j] - arr[j + 1];
                near[3] = arr[j] - arr[j + 2];
                
                if (near[0] < 0 || near[1] < 0 || near[2] < 0 || near[3] < 0) continue;
                else {
                    Arrays.sort(near);
                    ans = ans + near[0];
                }
            }
            i++;
            System.out.println("#" + i + " " + ans);
        }
 
   }
}
