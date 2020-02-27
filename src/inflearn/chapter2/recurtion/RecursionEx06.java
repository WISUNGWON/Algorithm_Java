package inflearn.chapter2.recurtion;

import java.util.Scanner;

public class RecursionEx06 {
    public static void main(String[] args) {

    }
 
    // 순차 탐색 (보통의 반복문)
    public int search(int[] data, int n, int target) {
        for (int i = 0; i < n; i++) {
            if (data[i] == target) {
                return i;
            }       
        }
        return -1;
    }
    
    // 매개변수 명시화 순차탐색
    int search(int[] data, int begin, int end, int target) {
        if (begin > end) {
            return -1;
        }
        else if (target == data[begin]) {
            return begin;
        }
        else {
            return search(data, begin + 1, end, target);
        }
            
    }
    
    // 순차 탐색 : 다른버전
    int seach(int[] data, int begin, int end, int target) {
        if (begin > end) {
            return -1;
        }
        else if (target == data[end]) {
            return end;
        }
        else {
            return search(data, begin, end - 1, target);
        }
    }
    
    // 순차 탐색 : 다른 버전2 
    int search2(int[] data, int begin, int end, int target) {
        if (begin > end) {
            return -1;
        }
        else {
            int middle = (begin + end) / 2;
            if (data[middle] == target) {
                return middle;
            }
            int index = search(data, begin, middle-1, target);
            if (index != -1) {
                return index;
            }
            else {
                return search(data, middle + 1, end, target);
            }
        }
    }
    
    // 최대값 찾기
    int findMax(int[] data, int begin, int end) {
        if (begin == end) {
            return data[begin];
        }
        else {
            return Math.max(data[begin], findMax(data, begin + 1, end));
        }
    }
    
    // 최대값 찾기 2
    int findMax2(int[] data, int begin, int end) {
        if (begin == end) {
            return data[begin];
        }
        else {
            int middle = (begin + end) / 2;
            int max1 = findMax(data, begin, middle);
            int max2 = findMax(data, middle + 1, end);
            return Math.max(max1, max2);
        }
       
    }
    
    // Binary Search
    public static int binarySearch(String[] items, String target, int begin, int end) {
        if (begin > end) {
            return -1;
        }
        else {
            int middle = (begin + end) / 2;
            int compResult = target.compareTo(items[middle]);
            if (compResult == 0) {
                return middle;
            }
            else if (compResult < 0) {
                return binarySearch(items, target, begin, middle - 1);
            }
            else {
                return binarySearch(items, target, middle + 1, end);
            }
        }
    }
}


