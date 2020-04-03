package array.backjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Remainder {
    
    private static final int N = 10;
    private static final int STANDARD_NUM = 42;

    public static void main(String[] args) {
        
        solution2();
   

                
               
                
                Scanner sc = new Scanner(System.in);
                
                Set<Integer> set = new HashSet<>();
                
                for (int i = 0; i < N; i++){
                    int num = sc.nextInt();
                    
                    set.add(num % STANDARD_NUM);
                }
                
                sc.close();
                System.out.println(set.size());
                
            }
        
        
        
    
    
    public static void solution1() {
        
        final int N = 10;
        final int STANDARD_NUM = 42;
        
        Scanner sc = new Scanner(System.in);
        
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < N; i++) {
            
            int num = sc.nextInt();
            
            if (num > 1000 || num < 0) {
                new RuntimeException("Out of Number;");
            }
            
            set.add(num % STANDARD_NUM);
            
        }
        
        System.out.println(set.size());
        
        
    }
    
    public static void solution2() {
        
        final int N = 10;
        final int STANDARD_NUM = 42;
        
        Scanner sc = new Scanner(System.in);
        
        int count = 0;
        boolean[] boo = new boolean[42];
        
        for (int i = 0; i < N; i++) {
            
            int num = sc.nextInt();
            
            if (num > 1000 || num < 0) {
                new RuntimeException("Out of Number;");
            }
            
            if (!boo[num % STANDARD_NUM]) {
                count++;
            }
            boo[num % STANDARD_NUM] = true;
            
        }
        
        System.out.println(count);
        
        
        
    }

}
