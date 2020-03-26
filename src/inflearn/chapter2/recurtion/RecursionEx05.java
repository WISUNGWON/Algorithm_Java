package inflearn.chapter2.recurtion;

import java.util.Scanner;

public class RecursionEx05 {
  public static void main(String[] args) {
      
     
      int[] arr = {1, 2, 3, 4, 5};



  }
 
  public static int length(String str) {
    if (str.equals(""))
      return 0; // base case
    else
      return 1 + length(str.substring(1));
  }
  
  
  public static void printChars(String str) {
    if (str.length() == 0)
      return;
    else {
      System.out.print(str.charAt(0)); 
      printChars(str.substring(1));
    }
  }
  
 
  public static void printCharsReverse(String str) {
    if (str.length() == 0)
      return;
    else {
      printCharsReverse(str.substring(1));
      System.out.print(str.charAt(0));
    }
  }

  public static void printInBinary(int n) {
    if (n < 2)
      System.out.print(n);
    else {
      printInBinary(n / 2);
      System.out.print(n % 2);
    }
  }
  

  public static int sum(int n, int[] data) {
    if (n <= 0) // base case
      return 0;
    else 
      return sum(n-1, data) + data[n-1]; // recursive case
  }
  

  public static void readFrom(int n, int[] data, Scanner in) {  
    if (n == 0)
      return;
    else {
      readFrom(n-1, data, in);
      data[n-1] = in.nextInt();
    }
  }
 
  
}


