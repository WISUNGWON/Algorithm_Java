package inflearn.chapter2.recurtion;

public class RecursionEx03 {
	public static void main(String[] args) {
      int result = func(4);
      System.out.println(result);
	}	
	// n(n+1)/2 = add from 0 to n
	public static int func(int n) {
	  if (n == 0) {
	      return 0;  
	  }
	  else {
	      return n + func(n - 1);  
	  }
		
	}
}
  