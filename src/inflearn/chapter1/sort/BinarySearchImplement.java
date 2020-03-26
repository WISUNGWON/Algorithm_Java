package inflearn.chapter1.sort;

import java.util.Arrays;
import java.util.Scanner;


public class BinarySearchImplement {

	public static void main(String[] args) {
	
	//  Scanner sc = new Scanner(System.in);
	  String[] str = {"kim", "berry", "back", "cris", "zcd", "jace", "jill"};
	  Arrays.sort(str); 
	  System.out.println(Arrays.toString(str));
	  System.out.println(binarySearch(str.length, str, "jace"));
	  
	  
	 
	}
	
	static int binarySearch(int n, String[] data, String target) {
		
	    int first = 0;
	    int last = n - 1;
	    int middle = (first + last) / 2;
	    while (first < last) {
	        
	        int result = data[middle].compareTo(target);
	        if (result == 0) {
	            return middle;
	        }
	        else if (result > 0) {
	            last = middle - 1;
	        }
	        else {
	            first = middle + 1;
	        }
	        
	    }
	    return -1;
	    
	}
	
	
}



