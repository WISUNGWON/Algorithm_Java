package dp2.backjoon;

// 2156 포도주 시식
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WineTasting {
    
    static int[] wine = new int[10001];
    static int[] dp = new int[10001];
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= n; i++) {
            int c = Integer.parseInt(br.readLine());
            wine[i] = c;
        }
        
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];
        
        
        int max = 0;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max((dp[i - 3] + wine[i - 1] + wine[i]), (dp[i - 2] + wine[i]));
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        max = Math.max(dp[n], dp[n - 1]);
        System.out.println(max);

    }

}
