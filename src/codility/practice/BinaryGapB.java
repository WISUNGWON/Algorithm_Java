package codility.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryGapB {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(solution(i));
    }
    public static int solution(int N) {
        
        ArrayList<Integer> binaryNumList = new ArrayList<>();
        
        while (N > 0) {
            binaryNumList.add(N % 2);
            N /= 2;
        }
        
        int binaryNumListSize = binaryNumList.size();
        int cntBinaryGap = 0;
        int maxBinaryGap = 0; //last return value
        
        for (int i = binaryNumListSize - 1; i >= 0; i--) {
            if (binaryNumList.get(i) == 1) {
                maxBinaryGap = maxBinaryGap(cntBinaryGap, maxBinaryGap);
                cntBinaryGap = 0;
            } else {
                cntBinaryGap++;
            }
            
        }
        return maxBinaryGap;
    }
    
    private static int maxBinaryGap(int cnt, int max) {
        if (max < cnt) {
            return cnt;
        }
        return max;
    }
}
