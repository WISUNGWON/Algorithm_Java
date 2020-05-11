package dp3.backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 1106번 
public class Hotel {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static StringTokenizer st;
    
    static int[][] info = new int[20][2]; // 행 = 각 도시 & 열 = 도시의 홍보비용, 비용으로 얻을 수 있는 고객수
    static int[] dp = new int[1001]; // 목표 고객의 최소 홍보 비용 저장. 
    
    static int hotel(int c, int n) { //customer: 목표 고객 수
        
        int min = 100001; // 홍보비용이 1, 고객수가 100일 때 1000명의 목표고객에서 얻을 수 있는 최대치. 
        int cost;
        
        if (c <= 0) { // 목표 고객수가 0또는 이하면 목표 달성
            return 0;
        } else if (dp[c] > 0) { // 이미 저장된 값이 있으면 저장된 값 리턴
            return dp[c];
        } else {
            for (int i = 0; i < n; i++) {
                cost = hotel(c - info[i][1], n) + info[i][0];
                min = cost < min ? cost : min;
            }
            dp[c] = min;
            
            return min;
        } 
    }
    
    public static void main(String[] args) throws IOException {
       
       st = new StringTokenizer(br.readLine());
       int c = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
       
       
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }
        
        System.out.printf("%d", hotel(c, n));
        
    }

}
