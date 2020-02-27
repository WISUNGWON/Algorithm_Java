package inflearn.chapter2.recurtion;

import java.util.Scanner;

public class RecursionEx05 {
  public static void main(String[] args) {

  }
  // ex 1) 문자열의 길이 계산
  public static int length(String str) {
    if (str.equals(""))
      return 0; // base case
    else
      return 1 + length(str.substring(1));
  }
  
  // ex 2) 문자열의 프린트
  public static void printChars(String str) {
    if (str.length() == 0)
      return;
    else {
      System.out.print(str.charAt(0)); //charAt(index) 문자열의 index에 해당하는 문자를 return.
      printChars(str.substring(1));
    }
  }
  
  // ex 3) 문자열을 뒤집어 프린트 
  public static void printCharsReverse(String str) {
    if (str.length() == 0)
      return;
    else {
      printCharsReverse(str.substring(1));
      System.out.print(str.charAt(0));
    }
  }
  // ex 4) 2진수로 변환하여 출력
  public void printInBinary(int n) {
    if (n < 2)
      System.out.print(n);
    else {
      printInBinary(n / 2);
      System.out.print(n % 2);
    }
  }
  
  // ex 5) 배열의 합 구하기
  public static int sum(int n, int[] data) {
    if (n <= 0) // base case
      return 0;
    else 
      return sum(n-1, data) + data[n-1]; // recursive case
  }
  
  // ex 6) 데이터파일로 부터 n개의 정수 읽어오기
  public void readFrom(int n, int[] data, Scanner in) { // Scanner in : data 파일을 참조. 
    if (n == 0)
      return;
    else {
      readFrom(n-1, data, in);
      data[n-1] = in.nextInt();
    }
  }
  
}


