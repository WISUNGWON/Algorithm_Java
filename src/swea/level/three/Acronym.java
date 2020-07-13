package swea.level.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 8741. 두문자어
public class Acronym {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int test;
        String[] strArr;
        String ans;
        
        test = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= test; test_case++) {
            strArr = br.readLine().split(" ");
            ans = "";
            for (int i = 0; i < 3; i++) {
                ans = ans + strArr[i].substring(0, 1).toUpperCase();
            }
            
            bw.write("#" + test_case + " " + ans + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();

    }

}
