package swea.lever.three;

import java.util.Scanner;

//8821. 적고 지우기
public class WriteAndErase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T, n, ans;
        String str;
        boolean[] check;
        
        T = sc.nextInt();
        
        for (int i = 1; i <= T; i++) {
            str = sc.next();
            check = new boolean[str.length()];
            ans = 0;
            for (int j = 0; j < check.length; j++) {
                n = Integer.parseInt(str.substring(j, j + 1));
                if (check[n] == false) {
                    check[n] = true;
                } else {
                    check[n] = false;
                }
            }
            
            for (int j = 0; j < check.length; j++) {
                if (check[j] == true) {
                    ans++;
                }
            }
            
            System.out.println("#" + i + " " + ans);
        }
        
        sc.close();

    }

}
