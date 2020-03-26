package programmers.codingtest.level1;

public class SumOfFactors {

    public static void main(String[] args) {
  

    }
    
    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++){
            int r1 = n / i;
            if (r1 * i == n) {
                answer = answer + i;
            }
        }
        
        return answer;
        
    }

}
