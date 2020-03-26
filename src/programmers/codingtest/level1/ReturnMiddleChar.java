package programmers.codingtest.level1;

public class ReturnMiddleChar {

    public static void main(String[] args) {
        
       System.out.println(solution("Stri2ng2"));
        
    }
    
    public static String solution(String s) {
        String answer = "";
        int sHalf = s.length() / 2;
            String[] arr;
            arr = s.split("");
            
            if (s.length() % 2 == 0) {
                answer = arr[sHalf - 1] + arr[sHalf];
            }
            else answer = arr[sHalf];
            return answer;
    }
    

}
