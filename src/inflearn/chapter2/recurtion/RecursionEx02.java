package inflearn.chapter2.recurtion;

public class RecursionEx02 {
	public static void main(String[] args) {
		int n = 4;
		func(n);
	}
	// ex 02) recursion doesn't always cause infinite loof.
	public static void func(int k) {
		if (k <= 0) // base case
		  return;
		else {
		  System.out.println("Hello...");
		  func(k-1); // recursive case
		  
		  //func(K+1); causing infinite loof. 
		}
	}
	
}
