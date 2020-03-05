package codility.practice;

import java.util.Arrays;

public class CyclicRotation {
    
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(test , 14)));
    }
    
    public static int[] solution(int[] A, int K) {
        
        if (A.length == 0) {
            return A;
        }
        
        if (A.length % K == 0) {
            return A;
        }
        
        else if (K > A.length) {
            K = K % A.length;
        }
        
        while (K > 0) {
            int sto = A[0]; 
            int dto = sto;
            A[0] = A[A.length - 1];
            for (int i = 1; i < A.length; i++) {
                dto = A[i];
                A[i] = sto;
                sto = dto;
                
            }
            K--;
        }
        return A;
    }
}
