package all.backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Resignation {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
 
        int[] T = new int[N + 2];
        int[] P = new int[N + 2];
        int[] dp = new int[N + 2];
        
        String[] str;
        for (int i = 1; i <= N; i++) {
            str = br.readLine().split(" ");
            T[i] = Integer.parseInt(str[0]);
            P[i] = Integer.parseInt(str[1]);
        }
        //------------입력부------------//
        
        for (int i = N; i > 0; i--) {
            int day = i + T[i];     // i번째 날의 상담기간

            if (day <= N + 1)
                dp[i] = Math.max(P[i] + dp[day], dp[i + 1]);
            else    // 상담일 초과
                dp[i] = dp[i + 1];
        }

        bw.write("" + dp[1]);
        
        br.close();
        bw.flush();
        bw.close();
    }
}

