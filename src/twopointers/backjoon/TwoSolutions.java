package twopointers.backjoon;

// 2470 µÎ ¿ë¾×
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoSolutions {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n - 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
           
        int pL = 0;
        int pR = n - 1;
        
        int result = arr[pL] + arr[pR];
        int resultPL = arr[pL];
        int resultPR = arr[pR];
        
        for (int i = 0; i < n - 1; i++) {
            dp[i] = arr[pL] + arr[pR];
  
            if (Math.abs(dp[i]) < Math.abs(result)) {
                result = dp[i];
                resultPL = arr[pL];
                resultPR = arr[pR];
            }
            
            if (dp[i] > 0) {
                pR--;
            } else if (dp[i] < 0) {
                pL++;
            } else {
                break;
            }  
        }
        
        System.out.println(resultPL + " " + resultPR);

    }

}
