package programmers.codingtest.level1;

import java.util.ArrayList;
import java.util.List;

public class MockTest {
    public static void main(String[] args) {

    }
    
    public int[] solution(int[] answers) {
        // 수포자의 찍기 패턴 수 st1 = 5, st2 = 8, st3 =10
        int[] st1 = {1, 2, 3, 4, 5};
        int[] st2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] st3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        //3명의 학생이므로 정답을 체크하기 위한 배열 cnt 생성
        int[] cnt = new int [3];
        
        // 정답과 찍은답을 비교하여 동일한 경우 cnt ++
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == st1[i % 5]) {
                cnt[0]++;
            }
            if (answers[i] == st2[i % 8]) {
                cnt[1]++;
            }
            if (answers[i] == st3[i % 10]) {
                cnt[2]++;
            }
        }
        
        // 1번 학생을 winner로 잡고 차례대로 비교하여 가장 높은 점수 확인
        int winner = cnt[0];
        for (int i = 0; i < cnt.length; i ++) {
            if (winner < cnt[i]) {
                winner = cnt[i];            }
        }
        
        // 가장 높은 점수를 받은 학생 List 생성
        List<Integer> win = new ArrayList<>();
        
        // cnt 배열과 가장 높은 점수를 비교하여 동일한 경우 win List에 추가 (학생 추가)
        for (int i = 0; i < cnt.length; i++) {
            if(winner == cnt[i]) {
                win.add(i);
            }
        }
        
        int[] answer = {}; // 출력값
        // 출력값은 win List에 추가된 학생 수와 동일하도록 길이 조정
        answer = new int[win.size()];
        
        // 출력할 배열 answer에 win List에 있는 학생번호 입력
        for (int i = 0; i < win.size(); i++) {
            // index는 0부터 시작하고 학생번호는 1부터 시작하므로 1씩 더해줌.
            answer[i] = win.get(i) + 1;
        }
        
        return answer;
    }
}
