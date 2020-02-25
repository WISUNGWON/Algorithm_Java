package inflearn.chapter1.sort;

import java.util.Arrays;

public class InsertionSortImplement {
	
	public static void main(String[] args) {
		
		int[] arrNum = {8, 5, 6, 2, 4};
		insertion_sort(arrNum.length, arrNum);
		System.out.println(Arrays.toString(arrNum));
	}
	
	static void insertion_sort(int n, int data[]) {
	  for (int i = 1; i < n; i++) { //2��° ������ �����Ͽ� ������ ������ ���ϴ� ������ �� �ڷ��(n) -1�� ��
	    int key = data[i]; //�ڸ��� ã���� ���� �ӽ÷� key������ ���� 
	    int j = i - 1; //�ٷ� ��(����)�� �ִ� ��(j = i - 1)���� ��
	    while ( (j >= 0) && (data[j] > key )) { //�� �۾� ����.�� �۾��� ���������� ù��° ������(j >= 0)
	      data[j + 1] = data[j]; //�� �۾� �������� �� ����� ��(data[j])�� �ڸ��� ã���� ��(data[i])���� ū ���, �� ����� ���� ���� �ڸ��� ã���� ������ ����(��ȯ�۾�)
	      j--; //���� ���ʼ� ��
	    }
	    data[j + 1] = key; //ã�� �ڸ��� �ڸ��� ã���� �� data[i] ����.
	  }
	}

}
