package swea.lever.three;

import java.util.Arrays;
import java.util.Scanner;

// SWEA 1244 최대 상금 
public class MaximumPrize {
    
    static int test, r;
    static String num;
    static int[] numArr;
 
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        test = sc.nextInt();
        while (i < test) {
            String ans = " ";
            num = sc.next();
            r = sc.nextInt();
            numArr = new int[num.length()];
            for (int j = 0; j < num.length(); j++) {
                numArr[j] = Integer.parseInt(num.substring(j, j + 1)); 
            }
            
            for (int j = 0; j < numArr.length; j++) {
               int maxIndex = j;
               for (int z = j + 1; z < numArr.length; z++) {
                   if (numArr[maxIndex] <= numArr[z]) {
                       maxIndex = z;
                   }
               }
               if (maxIndex != j) {
                   int temp; 
                   temp = numArr[j];
                   numArr[j] = numArr[maxIndex];
                   numArr[maxIndex] = temp;
                   r--;
                   if (r == 0) {
                       break;
                   }
             
               }
              
            }
            
            for (int j = 0; j < numArr.length; j++) {
                ans += numArr[j];
            }
            i++;
            System.out.println("#" + i + ans);
        }

    }

}
