package inflearn.chapter2.recurtion;


public class RecursionEx4 {
	public static void main(String[] args) {
      
	}
	// Factorial : n!
	public static int factorial (int n) {
		
	  if (n == 0)
	    return 1;
	  else
	    return n * factorial(n - 1);
	}
	// x^n = x*x^(n-1) (if n > 0)
	public static double power(double x, int n) {
		
	  if (n == 0)
	    return 1;
	  else
	    return x*power(x, n-1);
	}
	
	public static int fibonacci (int n) {
	  if (n < 2)
        return n;
	  else
	    return fibonacci(n-1) + fibonacci(n-2);
	}
}
  