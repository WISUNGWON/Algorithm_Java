package inflearn.chapter2.recurtion;


public class RecursionEx04 {
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
	
	// finonacci
	public static int fibonacci (int n) {
	  if (n < 2)
        return n;
	  else
	    return fibonacci(n-1) + fibonacci(n-2);
	}
	
	// find greatest common denominator
	public static double gcd(int m, int n) {
	  if (m < n) {
	    int tmp = m; m = n; n = tmp; // swap m and n
	  }
	  if (m % n == 0)
	    return n;
	  else
	    return gcd(n, m%n);
	}
	
	// find greatest common denominator simple
	public static int gcd2(int p, int q) {
	  if (q == 0)
	    return p;
	  else
	    return gcd2(q, p%q);
	}
}
  