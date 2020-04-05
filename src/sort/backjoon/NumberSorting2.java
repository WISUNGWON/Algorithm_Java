package sort.backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NumberSorting2 {
    
    static int[] sorted = new int[1000001];
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[number];
        
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }        
        
        mergeSort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();

    }
    
    static void merge(int a[], int m, int middle, int n) {
        int i = m;
        int j = middle + 1;
        int k = m;
        
        // 작은 순서대로 배열에 삽입.
        while (i <= middle & j <= n) {
            if (a[i] <= a[j]) {
                sorted[k] = a[i];
                i++;
            } else {
                sorted[k] = a[j];
                j++;
            }
            k++;
        }
        
        //남은 데이터도 삽입
        if (i > middle) {
            for (int t = j; t <= n; t++) {
                sorted[k] = a[t];
                k++;
            }
        } else {
            for (int t = i; t <= middle; t++) {
                sorted[k] = a[t];
                k++;
            }
        }
        
        // 정렬된 배열을 삽입
        for (int t = m; t <= n; t++) {
            a[t] = sorted[t];
        }
    }
    
    static void mergeSort(int a[], int m, int n) {
        //이외의 경우는 크기가 1개인 경우
        if (m < n) {
            int middle = (m + n) / 2;
            mergeSort(a, m, middle);
            mergeSort(a, middle + 1, n);
            merge(a, m, middle, n);
        }
    }

}