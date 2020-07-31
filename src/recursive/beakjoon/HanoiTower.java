package recursive.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
// 1914 하노이탑 백준
public class HanoiTower {

    private static StringBuilder sb;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        
        BigInteger K = new BigInteger("2"); // int보다 큰 수를 표현하기 위해 BigInteger 이용
        K = K.pow(N).subtract(BigInteger.ONE);
        System.out.println(K); // 옮긴 횟수 출력
        
        if (N <= 20) { // 원판의 개수가 20보다 작을 경우 수행 과정 출력
            move(1, 2, 3, N);
            System.out.println(sb.toString());
        }
    }

    private static void move(int one, int two, int three, int n) {
        if (n == 1) {
            sb.append(one).append(" ").append(three).append("\n");
            return;
        }
        move (one, three, two, n - 1);
        sb.append(one).append(" ").append(three).append("\n");
        move (two, one, three, n - 1);
        return;
        
    }

}
