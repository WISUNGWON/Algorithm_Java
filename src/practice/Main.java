package practice;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    
        public static void main(String[] args) throws IOException {
           
            Scanner sc = new Scanner(System.in);
            
            long A = sc.nextLong();
            long B = sc.nextLong();
            long C = sc.nextLong();
            
            System.out.println(power(A % C, B, C));
            
        }
        
        private static long power(long a, long b, long c) {
            if (b == 1) return a;
            
            long temp = power(a, b / 2, c) % c;
            
            if (b % 2 == 0) {
                return (temp * temp) % c;
            } else {
                return (((temp * temp) % c) * a) % c;
            }
        }
 
}


