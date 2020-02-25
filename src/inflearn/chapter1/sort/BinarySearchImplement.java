package inflearn.chapter1.sort;

import java.util.Arrays;
import java.util.Scanner;


public class BinarySearchImplement {

	public static void main(String[] args) {
	
	//  Scanner sc = new Scanner(System.in);
	  String[] str = {"kim", "berry", "back", "cris", "zcd", "jace", "jill"};
	  Arrays.sort(str); // �迭�� '������' �Ǵ� 'abc'������ ����, int�� �迭�� �Է��ϸ� '��������'����
	  System.out.println(Arrays.toString(str));
	  System.out.println(binarySearch(str.length, str, "jace"));
	  
	  
	 
	}
	
	static int binarySearch(int n, String[] data, String target) {
		
	  int begin = 0, end = n-1;
	  while(begin <= end) {
	    int middle = (begin + end) / 2;
	    int result = data[middle].compareTo(target);
	    if (result == 0)
	    	return middle;
	    else if (result < 0)
	    	begin = middle + 1;
	    else 
	    	end = middle - 1;
	  }
	  return -1;
	}
	
}


/*
 * String �迭 ��� (Arrays.toSting())
 * �迭 ��������, �������� ���� (Arrays.sort() / Arrays.sort()���� 
*/
