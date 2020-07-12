package swea.lever.three;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//7728 다양성 측정
public class DiversityMeasure {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        String N;
        char[] arr;
        Set s;
        T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            N = sc.next();
            arr = N.toCharArray();
            s = new HashSet<>();
            for (int j = 0; j < arr.length; j++) {
                s.add(arr[j]);
            }
            
            System.out.println("#" + T + " " + s.size());
            
        }
        
        sc.close();

    }

}
