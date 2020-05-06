package dp2.backjoon;
// 1912 ¿¬¼ÓÇÕ
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ContinuiusSum {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];            
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[0] = arr[0];
        
        for (int i = 1; i < n; i++) {
          if (dp[i - 1] < 0) {
              dp[i] = arr[i];
          } else {
              dp[i] = dp[i - 1] + arr[i];
          }
        }
        
        int max = -1000;
        for (int i : dp) {
            if (i > max) {
                max = i;
            }
        }
        
        bw.write(max + "");
        
        bw.flush();
        bw.close();
        br.close();
    }

}
