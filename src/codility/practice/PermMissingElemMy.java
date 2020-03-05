package codility.practice;

import java.util.Arrays;

public class PermMissingElemMy {
    public static void main(String[] args) {
        int[] test = {3,2,4,5,6,7};
        System.out.println(solution(test));
        
    }
    
    public static int solution(int[] A) {
        
        if (A.length == 1) {
            return 0;
        }
        int answer = 0;
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        for (int i = 0; i < A.length; i++){
            if (A[i] != i + 1){
                return answer = i + 1;
            }
        }
        return answer;
    }

}
