package swea.lever.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 7964. 부먹왕국의 차원 관문
public class BumuckGate {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T, C = 0, D = 0;
        String[] arrStr;
        boolean[] arrC;
        int ans = 0;
        
        T = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= T; i++) {
            arrStr = br.readLine().split(" ");
            ans = 0;
            for (int j = 0; j < arrStr.length; j++) {
                C = Integer.parseInt(arrStr[0]);
                D = Integer.parseInt(arrStr[1]);
            }
            
            arrC = new boolean[C + 2]; //false는 차원관문(1) , true는 0
            
            
            
            arrStr = br.readLine().split(" ");
            
            for (int z = 1; z < arrC.length - 1; z++) {
                
                if (arrStr[z - 1].equals("0")) { // equals를 안쓰고 그냥 ==를 비교하면 배열의 String "값"이 아닌 주소값을 비교하기 때문에 if문에 들어가지 않는다.
                    arrC[z] = true;
                }
                
            }
            
            for (int j = 0; j < arrC.length - D; j++) {
                if (arrC[j] == false) { // 차원관문이면.
                    for (int z = 1; z <= D; z++) {
                        if (!arrC[j + z]) { // false이면
                            j = j + z - 1;
                            break;
                        } 
                        else if (z == D) {
                            arrC[j + z] = false;
                            j = j + z - 1;
                            ans++;
                        }
                    }
                }
            }
            
            bw.write("#" + i + " " + ans + "\n");
            
        }
        
        br.close();
        bw.close();
    }
    
    

}
