package dp.backjoon;

import java.util.Scanner;

public class RGBdistance {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int[][] house = new int[1001][3]; // �� ��(i)�� ����(0) �ʷ�(1) �Ķ�(2) ����� 2���� �迭�� ����.
        int[][] dp = new int[1001][3]; // �� ���� ĥ�� �� ���� �ּҺ���� dp �迭�� ����.
        int result = 0;
        int n = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {
            house[i][0] = sc.nextInt();
            house[i][1] = sc.nextInt();
            house[i][2] = sc.nextInt();
        }
        
        dp[1][0] = house[1][0]; // ù ���� ĥ�� �� ���� �ּ� ����� �� ���� ���� ��� �� ��ü��.
        dp[1][1] = house[1][1];
        dp[1][2] = house[1][2];
        
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + house[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + house[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + house[i][2];
        }
        
        result = Math.min(dp[n][2], Math.min(dp[n][0], dp[n][1]));
        
        System.out.println(result);
        
        sc.close();
    }

}