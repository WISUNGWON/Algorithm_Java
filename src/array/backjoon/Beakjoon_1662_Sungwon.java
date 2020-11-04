package array.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Beakjoon_1662_Sungwon {
  static int[] paren = new int[50];
  static char[] s;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Integer> st = new Stack();
    s = br.readLine().toCharArray();
    
    // paran배열에 [index ='('] = ')'값으로 짝지어주기
    for (int i = 0; i < s.length; i++) {
      if (s[i] == '(') {
    	  st.push(i);
      }
      if (s[i] == ')') {
    	  paren[st.pop()] = i;
      }
    }
    System.out.println(solution(0, s.length));
  }

  static int solution(int start, int end) {
    int ans = 0;

    for (int i = start; i < end; i++) {
      if (s[i] == '(') {
        ans += (s[i - 1] - '0') * solution(i + 1, paren[i]) - 1; // 시작은 무조건 한자리의 정수이기 때문에 - 1을 뺀다
        i = paren[i];
      } else {
        ans++;
      }
    }
    return ans;
  }
}