package dp2.backjoon;

// 11053 가장 긴 증가하는 부분 수열 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[1001];
        int[] dp = new int[1001];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i]++;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i] < arr[j] && dp[i] >= dp[j]) {
                    dp[j]++;
                }
            }
        }
        
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
       
        System.out.println(max);
        
        
    }

}
