package programmers.codingtest.level1;

import java.util.Arrays;
import java.util.Collections;

public class IntDescent {
    public static void main(String[] args) {
        
    }    
    
    public static long solution(long n) {
        long answer;
        String s;
        String s2 = "";
       
        
        // long to String 
        s = String.valueOf(n);
        
        // char to int and put it into long[]
        Integer[] arrInt = new Integer[s.length()];
        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = Character.getNumericValue(s.charAt(i));
        }
        
        // descent long[]
        Arrays.sort(arrInt, Collections.reverseOrder());
 
        
        // int to String and connect each chars
        for (int i = 0; i < arrInt.length; i++) {
            s2 = s2 + String.valueOf(arrInt[i]);
        }
      
   
        // String to long
        return answer = Long.parseLong(s2);
        
 
    }
    
    public static long solution2(long n) {
        String answer ="";
        char[] temp = (n + "").toCharArray();
        Arrays.sort(temp);
        for (int i = temp.length - 1; i >= 0; i--) {
            answer += temp[i] + "";
        }
        return Long.parseLong(answer);
    }
   
}
