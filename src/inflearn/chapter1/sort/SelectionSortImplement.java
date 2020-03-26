package inflearn.chapter1.sort;

import java.util.Arrays;

public class SelectionSortImplement {

	public static void main(String[] args) {
		
		int[] arrNum = {9, 6, 7, 3, 5};
		selectionSort(arrNum);
		
		for(int i = 0; i < arrNum.length; i++){
		    System.out.printf("%d, ", arrNum[i]);
		}

	}
	
	static void selectionSort(int[] list) {
	    int indexMin, temp = 0;

	    for (int i = 0; i < list.length - 1; i++){ 
	        indexMin = i;
	        for (int j = i + 1; j < list.length; j++) {
	            if (list[j] < list[indexMin]) {
	                indexMin = j;
	            }
	        }

	        temp = list[indexMin];
	        list[indexMin] = list[i];
	        list[i] = temp;

	    }
	}

	
	

	
}
	  


