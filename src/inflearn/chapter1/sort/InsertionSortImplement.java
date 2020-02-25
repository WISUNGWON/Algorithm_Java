package inflearn.chapter1.sort;

import java.util.Arrays;

public class InsertionSortImplement {
	
	public static void main(String[] args) {
		
		int[] arrNum = {8, 5, 6, 2, 4};
		insertion_sort(arrNum.length, arrNum);
		System.out.println(Arrays.toString(arrNum));
	}
	
	static void insertion_sort(int n, int data[]) {
	  for (int i = 1; i < n; i++) { //2번째 값부터 시작하여 마지막 값까지 비교하는 수행을 총 자료수(n) -1번 함
	    int key = data[i]; //자리를 찾아줄 값을 임시로 key변수에 저장 
	    int j = i - 1; //바로 옆(왼쪽)에 있는 값(j = i - 1)부터 비교
	    while ( (j >= 0) && (data[j] > key )) { //비교 작업 수행.비교 작업은 최종적으로 첫번째 값까지(j >= 0)
	      data[j + 1] = data[j]; //비교 작업 과정에서 비교 대상의 값(data[j])이 자리를 찾아줄 값(data[i])보다 큰 경우, 비교 대상의 값을 현재 자리를 찾아줄 값으로 대입(교환작업)
	      j--; //다음 왼쪽수 비교
	    }
	    data[j + 1] = key; //찾은 자리에 자리를 찾아줄 값 data[i] 대입.
	  }
	}

}
