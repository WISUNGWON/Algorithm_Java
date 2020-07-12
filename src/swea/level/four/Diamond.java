package swea.level.four;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Diamond {
    
    
    static int[] arr = new int[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T, N, K, max, sum;
        String[] strArr;
        
        
        T = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= T; i++) {
            strArr = br.readLine().split(" ");
            N = Integer.parseInt(strArr[0]);
            K = Integer.parseInt(strArr[1]);
            
            Arrays.fill(arr, 0);
            for (int j = 0; j < N; j++) { //다이아몬드 크기 배열에 저장
                arr[Integer.parseInt(br.readLine())]++;
            }
            
            max = 0;
            
            for (int x = 1; x <= 1 + K; x++) {
                max += arr[x];
            }
           
            sum = max;
            
            for (int y = 1; y < arr.length - K - 1; y++) {
                sum = sum + arr[y + K + 1] - arr[y];
                if (max < sum) {
                    max = sum;
                }
                    
            }
            
            bw.write("#" + i + " " + max + "\n");
            
        }
        
        br.close();
        bw.flush();
        bw.close();

    }

}
