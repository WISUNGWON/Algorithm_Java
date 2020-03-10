package codility.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TapeEquilibrium {
   
        
     public static void main(String[] args) {
            int[] A = {3, 1, 2, 4, 3};
            System.out.println("결과 : " + solution(A));
     }
     
     public static int solution(int[] A) {
         List sumList = new ArrayList();
         
         int left = 0;
         int right = 0;
         int sum = 0;
         
         for (int i : A) sum += i;
         
         for (int j = 1; j < A.length; j++) {
             left += A[j - 1];
             right = sum - left;
             sumList.add(Math.abs(left - right)); 
         }
         return (int)Collections.min(sumList);
     }
    
}
