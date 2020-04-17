package greedy.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class NewEmployee {
    
    

    public static void main(String[] args) throws IOException {
        
        Map<Integer, Integer> a = new HashMap<Integer, Integer>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        
        while (t > 0) {
            a.clear();
            int n, min = 100001, result = 0;
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String x;
                x = br.readLine();
                String[] arr = x.split(" ");
                a.put(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
            }
            
            TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>(a);
            
            
            for (Integer key : tm.keySet()) {
                if (min > tm.get(key)) {
                    min = tm.get(key);
                    result ++;
                }
            }

            System.out.println(result);
            t--;
        }
   
    }

}
