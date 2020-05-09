package all.backjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MinusBinary {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        
        if (n == 0) {
            System.out.println(0);
        } else {
            while (n != 0) {
                list.add(Math.abs(n % -2));
                n = (int)Math.ceil((double)n / -2);
            }
            
            int[] arr = new int[list.size()];
            
            for (int i = list.size() - 1; i >= 0; i--) {
                arr[i] = list.get(i);
                System.out.print(arr[i]);
            }
            
            System.out.println();
            System.out.println(Arrays.toString(arr));
        }
       
        sc.close();
        
    }
}
