package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static int[] ans = new int[101];
    
    public static void main(String[] args) throws IOException {
      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int x = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        
        x = getTarget(a);
        
        System.out.println(x);
        

        
        
        
    }
    
    public static int getTarget(int[] a) {
        int val = 1;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                sum += val;
            }
            
            val *= -2;
        }
        
        int target = 0;
        if (sum > 0) {
            target = (sum % 2 != 0) ? sum / 2 + 1 : sum / 2;
        } else {
            target = sum / 2;
        }
        
        return target;
    }
    
    public static String solution(int x) {
        String s = "";
        
        while (x != 0) {
            
        }
        
        return s;
    }
    

    
    
    

}
