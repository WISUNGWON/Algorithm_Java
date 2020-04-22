package dp.backjoon;

import java.util.Scanner;

//14852 Ÿ��ä��� 3
public class Tailing4 {
  
  static long[][] tail = new long[1000001][2]; // 2��° ���� ������ ����� ���� ���
  
  public static void main(String[] args) {
     
      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt();
      
      System.out.println(tailing(n));
      
      sc.close();

  }
  
  public static long tailing(int n ) {
      tail[0][0] = 1;
      tail[1][0] = 2;
      tail[2][0] = 7;
      tail[2][1] = 0;
      for (int i = 3; i <= n; i++) {
          tail[i][1] = (tail[i - 1][1] + tail[i - 3][0]) % 1000000007; // ������ ������ 2���� �Լ�������
          System.out.println(i + "���� tail[i][1]�� : " + tail[i][1]);
          tail[i][0] = (3 * tail[i - 2][0] + 2 * tail[i - 1][0] + 2 * tail[i][1]) % 1000000007;
      }
      
      return tail[n][0];
  }

}
