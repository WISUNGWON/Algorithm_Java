package greedy.backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;

// 2217 로프
public class Rope {

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        int n;
        int rope;
        
        n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            rope = Integer.parseInt(br.readLine());
            a[i] = rope;
            
        }
        
        Arrays.sort(a);
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < a[i] * (n - i)) {
                max = a[i] * (n - i);
            }
        }
        
        bw.write(max + "");
        
        br.close();
        bw.flush();
        bw.close();
    }
}

