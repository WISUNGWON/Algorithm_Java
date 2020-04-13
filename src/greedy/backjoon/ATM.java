package greedy.backjoon;

//11399 ATM
import java.util.Arrays;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int result = 0;
        int sum = 0;
        int n = sc.nextInt();
        int[] arr = new int[n]; // 주어진 조건보다 1 크게 명시함
        
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            arr[i] = p;
        }   
        
        Arrays.sort(arr);
        
        
//        for (int i = 0; i < n; i++) {
//            sum += arr[i];
//            result += sum;
//
//            
//        }
        
        /*
         * 3,1,4,3,2분을 오름차순으로하면 1,2,3,3,4분이 되죠? 
         * 여기서 총 걸린 시간은 1분,1분+2분,1분+2분+3분
         *  이런식으로 가기때문에 총 1분이 5번(5-0) 2분이 4번(5-1) 3분이 3번(5-2), 
         *  2번(5-3) 4분이 1번(5-4) 들어가게 됩니다. 그래서 (n-i)번을 곱해주는거네요
         */
        
        for (int i = 0; i < n; i++) {
            sum += arr[i] * (n - i);
        }
        
        System.out.println(sum);

    }

}
