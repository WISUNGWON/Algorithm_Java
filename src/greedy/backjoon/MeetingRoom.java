package greedy.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MeetingRoom {

    public static void main(String[] args) throws IOException {
       
        Map<Long, Long> timeMap = new HashMap<Long, Long>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long last;
        long result = 0;
        long n = Long.parseLong(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String[] time = br.readLine().split(" ");
            timeMap.put(Long.parseLong(time[1]), Long.parseLong(time[0]));
        }
        
        TreeMap<Long, Long> timeTree = new TreeMap<>(timeMap);
        long firstKey = timeTree.firstKey();
        last = firstKey;
        for (Long key : timeTree.keySet()) { 
            if (n == 1) {
                result++;
                break;  
            }
            
            if (last > timeTree.get(key) && last == key) {
                result++;
            }
            
            if (last <= timeTree.get(key)) {
                last = key;
                result++;
            }
        }
        
        System.out.println(result);
        

    }

}
