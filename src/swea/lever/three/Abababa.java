package swea.lever.three;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 8840 아바바바
public class Abababa {

    public static void main(String[] args) throws IOException {
       
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int test_case = 1; test_case <= T; test_case++) {
            long L = sc.nextLong() / 2;
            bw.write("#" + test_case + " " + L * L + "\n");
        }
        bw.flush();
        bw.close();
        sc.close();
    }
}
