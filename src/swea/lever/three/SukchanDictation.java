package swea.lever.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// swea level3 9317 석찬이의 받아쓰기
public class SukchanDictation {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            char[] standard = br.readLine().toCharArray();
            char[] compare = br.readLine().toCharArray();
            int cnt = 0;
            for(int i=0; i < n; i++) {
                if(standard[i] == compare[i]) {
                    cnt++;
                }
            }
            bw.write("#"+ t + " "+ cnt + "\n");
        }
        bw.close();
        br.close();

    }


}
