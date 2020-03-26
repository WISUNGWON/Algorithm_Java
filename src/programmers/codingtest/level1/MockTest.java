package programmers.codingtest.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockTest {
    public static void main(String[] args) {
        
        int[] answer = {1, 3, 2, 4, 2};
        int[] answer2 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(answer)));
        System.out.println(Arrays.toString(solution(answer2)));

    }
    
    public static int[] solution(int[] answers) {
        
        int[] st1 = {1, 2, 3, 4, 5};
        int[] st2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] st3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] cnt = new int [3];
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == st1[i % 5]) {
                cnt[0]++;
            }
            if (answers[i] == st2[i % 10]) {
                cnt[1]++;
            }
            if (answers[i] == st3[i % 10]) {
                cnt[2]++;
            }
        }
        
        int winner = cnt[0];
        for (int i = 1; i < cnt.length; i++) {
            if (winner < cnt[i]) {
                winner = cnt[i];
            }
        }
        
        List<Integer> win = new ArrayList<>();
        
        for (int i = 0; i < cnt.length; i++) {
            if (winner == cnt[i]) {
                win.add(i);
            }
        }
        
        int[] answer = {};
        
        answer = new int[win.size()];
        
        for (int i = 0; i < win.size(); i++) {
            answer[i] = win.get(i) + 1;
        }
        
        return answer;

    }
}
