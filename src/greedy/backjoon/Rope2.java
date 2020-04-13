package greedy.backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2217 로프
public class Rope2 {

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int rope = 0;
        int min = 10000;
        for (int i = 0; i < n; i++) {
            rope = Integer.parseInt(br.readLine());
            if (min > rope) {
                min = rope;
            }
        }
        
    
        System.out.println(min * n);
        
        br.close();
    }
    
    

}