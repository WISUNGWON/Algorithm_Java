package swea.lever.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 9480 ¹ÎÁ¤ÀÌ¿Í ±¤Á÷ÀÌÀÇ ¾ËÆÄºª°øºÎ
public class MinjungGwangjicAlpa {
    
    static int result;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            result = 0;
            boolean[][] arr = new boolean[n][26];
            for (int i = 0; i < n; i++) {
                char[] str = br.readLine().toCharArray();
                for (int j = 0; j < str.length; j++) {
                    arr[i][str[j] - 'a'] = true;
                }
            }
            dfs(0, n, arr, new int[26]);
            bw.write("#" + t + " " + result + "\n");
        }
        bw.close();
        br.close();
    }
    
    static void dfs(int depth, int cnt, boolean[][] arr, int[] check) {
        if (depth == cnt) {
            int flag = 0;
            for (int i = 0; i < check.length; i++) {
                if (check[i] >= 1) {
                    flag++;
                }
            }
            if (flag == 26) {
                result++;
            }
            return;
        }
        
        for (int j = 0; j < arr[depth].length; j++) {
            if (arr[depth][j]) {
                check[j]++;
            }
        }
        dfs(depth + 1, cnt, arr, check);
        for (int j = 0; j < arr[depth].length; j++) {
            if(arr[depth][j]) {
                check[j]--;
            }
        }
        dfs(depth + 1, cnt, arr, check);
    }

}
