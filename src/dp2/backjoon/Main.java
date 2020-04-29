package dp2.backjoon;

// 11053 ���� �� �����ϴ� �κ� ���� 
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
        }
        
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }
        
        System.out.println(max);
        
        
        

    }

}
