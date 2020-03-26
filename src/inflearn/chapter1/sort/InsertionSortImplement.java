package inflearn.chapter1.sort;

import java.util.Arrays;

public class InsertionSortImplement {
	
	public static void main(String[] args) {
		
		int[] arrNum = {2, 3, 6, 2, 4};
		insertion_sort(arrNum.length, arrNum);
		System.out.println(Arrays.toString(arrNum));
	}
	
	static void insertion_sort(int n, int data[]) {
	    for (int i = 1; i < n; i++) {
	        int key = data[i];
	        int j = i - 1;
	        while (j >= 0 && data[j] > key) {
	            data[j + 1] = data[j];
	            j--;
	        }
	        data[j + 1] = key;
	    }
	}

}
