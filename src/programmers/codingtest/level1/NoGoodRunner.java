package programmers.codingtest.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NoGoodRunner {

    public static void main(String[] args) {
      
        String[] parti = {"leo", "kiki", "eden"};
        String[] comple = {"kiki", "leo"};
        
     
        System.out.println(solution(parti, comple));
        System.out.println(solution2(parti, comple));
        

    }
    //해시맵 이용한 풀이 (해시맵은 key값의 중복을 허용하지 않고, 중복일 경우 가장 나중에 들어온 key값의 value로 최신화함)
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        int val = 0;
        
        //해시맵 생성 <선수, 중복판단할 value값>
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        
        //participant배열에 있는 값 해시맵에 넣기.
        for (String part : participant) {
            if (hm.get(part) == null) {
                hm.put(part, 1);
            }
            //중복처리
            else {
                val = hm.get(part) + 1;
                hm.put(part, val); //중복 key값의 value update
            }
                                   
        }

        //completion배열에 있는 값 해시맵에 넣기. (completion에 있는 선수는 participant에도 있다)
        for (String comp : completion) {
            val = hm.get(comp) - 1;
            hm.put(comp, val);
        }
        
   
        //key값을 각각 확인하여 1을 value로 가지고 있는 key를 answer에 저장.
        for (String set : hm.keySet()) {
            if (hm.get(set) == 1) {
                answer = set;
            }
        }

   
        return answer;
    }
    
    public static String solution2(String[] participant, String[] completion) {
        Arrays.parallelSort(participant);
        Arrays.sort(completion);
        int i;
        for (i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[i];
        
    }
    
    //최적풀이
    public String solution3(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
    
    /*
     * 효율성 면에서 좋은 답안이 아닙니다. 
     * keySet하고 또 get하는 건 매우 비효율적인 코드입니다.
     *  get할 때마다 계속 HashMap을 search하니까요.
     *   key, value를 같이 가져올 때는 항상 entrySet을 사용해야 해요.
     */
    
 

}
