package dp3.backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 1106�� 
public class Hotel {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static StringTokenizer st;
    
    static int[][] info = new int[20][2]; // �� = �� ���� & �� = ������ ȫ�����, ������� ���� �� �ִ� ����
    static int[] dp = new int[1001]; // ��ǥ ���� �ּ� ȫ�� ��� ����. 
    
    static int hotel(int c, int n) { //customer: ��ǥ �� ��
        
        int min = 100001; // ȫ������� 1, ������ 100�� �� 1000���� ��ǥ������ ���� �� �ִ� �ִ�ġ. 
        int cost;
        
        if (c <= 0) { // ��ǥ ������ 0�Ǵ� ���ϸ� ��ǥ �޼�
            return 0;
        } else if (dp[c] > 0) { // �̹� ����� ���� ������ ����� �� ����
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
