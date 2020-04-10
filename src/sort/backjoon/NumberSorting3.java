package sort.backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NumberSorting3 {
    
    static int n;
    static int[] a = new int[10001];

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            a[x]++;
        }
        
        for (int i =0; i < 10001; i++) {
            while(a[i] != 0) {
                bw.write(i + "\n");
                a[i]--;
            }
        }
        
        br.close();
        bw.flush();
        br.close();
        

    }

}
