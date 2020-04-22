package dp.backjoon;

import java.util.Scanner;

//2133 Ÿ��ä���
public class Tailing3 {
  
  static int[] tail = new int[1001];
  
  public static void main(String[] args) {
     
      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt();
      
      System.out.println(tailing(n));
      
      sc.close();

  }
  
  public static int tailing(int n ) {
      if (n == 0) {
          return tail[n] = 1; //4���� ������� ����� ���� ó��
      }
      if (n == 1) {
          return tail[n] = 0; //4������ n�� 1�� �� 
      }
      if (n == 2) {
          return tail[n] = 3;
      }
      if (tail[n] != 0 && n > 2) {
          return tail[n];
      }
      int result = 3 * tailing(n - 2);
      for (int i = 3; i <= n; i++) {
          if (i % 2 == 0) {
              result += 2 * tailing(n - i);
          }
      }
      
      return tail[n] = result;
  }

}
