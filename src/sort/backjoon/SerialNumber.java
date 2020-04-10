package sort.backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SerialNumber {
    
   static int getSum (String a) {
        int length = a.length(), sum = 0;
        for (int i = 0; i < length; i++)  {
            if (a.charAt(i) <= '9' && a.charAt(i) >= '0') {
                sum += a.charAt(i) - '0';
            }  
               
        }
        return sum;
    };

    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> set = new HashSet<String>();
        int n = Integer.parseInt(br.readLine().trim());
        
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        
        List<String> list = new ArrayList(set);
        

        
        Comparator<String> myComparator = new Comparator<String>() {
            public int compare (String x, String y) {
                if (x.length() > y.length()) {
                    return 1;
                }
                else if (x.length() == y.length()) {

                    if(getSum(x) != getSum(y)) {
                        return Integer.compare(getSum(x), getSum(y)); //Integer는 10자리까지만 된다?
                    }
                    else {
                        return x.compareTo(y);   
                    }
                }
                else {
                    return -1;
                }
            }
            
        };
        
        Collections.sort(list, myComparator);
        
        for (String s : list) {
            bw.write(s + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
        
        
        
    }
    
  
}
