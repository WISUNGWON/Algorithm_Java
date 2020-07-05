package swea.lever.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 8500. 극장 좌석
public class ATheaterSeat {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T, N, max, ans;
        String[] strArr;
        
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            strArr = br.readLine().split(" ");
            max = 1;
            ans = 0;
            for (int j = 0; j < N; j++) {
                ans += Integer.parseInt(strArr[j]);
                if (max < Integer.parseInt(strArr[j])) {
                    max = Integer.parseInt(strArr[j]);
                  
                }
            }
            
            ans = ans + max + N;
            bw.write("#" + i + " " + ans + "\n");
        }
        
        br.close();
        bw.close();
    }

}
