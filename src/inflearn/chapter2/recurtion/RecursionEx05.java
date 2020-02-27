package inflearn.chapter2.recurtion;

import java.util.Scanner;

public class RecursionEx05 {
  public static void main(String[] args) {

  }
  // ex 1) ���ڿ��� ���� ���
  public static int length(String str) {
    if (str.equals(""))
      return 0; // base case
    else
      return 1 + length(str.substring(1));
  }
  
  // ex 2) ���ڿ��� ����Ʈ
  public static void printChars(String str) {
    if (str.length() == 0)
      return;
    else {
      System.out.print(str.charAt(0)); //charAt(index) ���ڿ��� index�� �ش��ϴ� ���ڸ� return.
      printChars(str.substring(1));
    }
  }
  
  // ex 3) ���ڿ��� ������ ����Ʈ 
  public static void printCharsReverse(String str) {
    if (str.length() == 0)
      return;
    else {
      printCharsReverse(str.substring(1));
      System.out.print(str.charAt(0));
    }
  }
  // ex 4) 2������ ��ȯ�Ͽ� ���
  public void printInBinary(int n) {
    if (n < 2)
      System.out.print(n);
    else {
      printInBinary(n / 2);
      System.out.print(n % 2);
    }
  }
  
  // ex 5) �迭�� �� ���ϱ�
  public static int sum(int n, int[] data) {
    if (n <= 0) // base case
      return 0;
    else 
      return sum(n-1, data) + data[n-1]; // recursive case
  }
  
  // ex 6) ���������Ϸ� ���� n���� ���� �о����
  public void readFrom(int n, int[] data, Scanner in) { // Scanner in : data ������ ����. 
    if (n == 0)
      return;
    else {
      readFrom(n-1, data, in);
      data[n-1] = in.nextInt();
    }
  }
  
}


