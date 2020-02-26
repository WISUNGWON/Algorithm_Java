package inflearn.chapter2.recurtion;

public class RecursionEx01 {

	public static void main(String[] args) {
		
		func(); 
		
		
	}
	
	// ex 01) recursion cause infinite roof
	public static void func() {
		
		System.out.println("Hello...");
		func();
		
	}	
}
