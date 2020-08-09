package swea.level.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Ladder1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] m = new int[100][100];
        for (int testCase = 1; testCase <= 10; testCase++) {
            br.readLine();
             
            for (int i = 0; i < m.length; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < m.length; j++) {
                    m[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int row = 99;
            int col = -1;
            for (int i = 0; i < m.length; i++) {
                if (m[99][i] == 2) {
                    col = i;
                    break;
                }
            }
             
            int dir = 1; // 1:상, 2:좌, 3:우
             
            while(true) {
                if (row == 0) break;
   
                 
                if (dir!=3 && col-1 >= 0 && m[row][col-1] == 1) { // 좌
                    col--;
                    dir = 2;
                } else if (dir!=2 && col+1 < 100 && m[row][col+1] == 1) { // 우
                    col++;
                    dir = 3;
                } else { // 상
                    row--;
                    dir = 1;
                }
            }
            System.out.println("#"+testCase+" "+col);
        } // end of for testCase
    } // end of main
} // end of class
 
 
 
 
 
 
 
 