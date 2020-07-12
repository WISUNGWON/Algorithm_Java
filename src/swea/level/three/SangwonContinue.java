package swea.lever.three;

import java.util.Scanner;

// 7510 상원이의 연속합
public class SangwonContinue {

    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            int cnt = 0;
            for(int i = 1; i <= n; i++) {
                int sum = 0;
                for(int j = i; j <= n; j++) {
                    sum += j;
                    if(sum == n) {
                        cnt++;
                        break;
                    }
                    else if(sum > n) {
                        break;
                    }
                }
            }
            System.out.println("#" + t + " " + cnt);
        }
    }
}
