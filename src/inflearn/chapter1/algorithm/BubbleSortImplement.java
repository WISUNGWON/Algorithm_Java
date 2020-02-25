package inflearn.chapter1.algorithm;

import java.util.Arrays;

public class BubbleSortImplement {

	public static void main(String[] args) {
		
	  int[] numArr = {8, 5, 3, 2, 9};
	  bubbleSort(numArr, numArr.length);
	  System.out.println(Arrays.toString(numArr));

	}
	
	static void bubbleSort(int data[], int n) {
	  for (int i = n-1; i > 0; i--) {
	    for (int j = 0; j < i; j++) {
	      if (data[j] > data[j + 1]) {
	        int tmp = data[j];
	        data[j] = data[j + 1];
	        data[j + 1] = tmp;
	      }
	    }
	  }
		
	}

}
