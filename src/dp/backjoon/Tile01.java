package dp.backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1904¹ø 01Å¸ÀÏ
public class Tile01 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        long dp1 = 1;
        long dp2 = 2;
        long result = 3;
        if (n == 1)
            result = 1;
        else if (n == 2) {
            result = 2;
        } 
        else if (n > 2) {
            for (int i = 3; i <= n; i++) {
            result = (dp1 + dp2) % 15746;
            dp1 = dp2;
            dp2 = result;
            }
          }
       
        bw.write(result + "\n");
        
        bw.flush();
        br.close();
        bw.close();

    }

}
