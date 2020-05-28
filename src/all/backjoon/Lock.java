package all.backjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lock {
    
    static int n, x, cnt;

    
    public static void main(String[] args) {
       
       int i;
       int add;
       Scanner sc = new Scanner(System.in);
       n = sc.nextInt();
       List<Integer> lock = new ArrayList<Integer>();
       int[] index = new int[n + 1];
       for (i = 0; i < n; i++) {
           add = sc.nextInt();
           lock.add(add);
       }
       for (i = 0; i < n; i++) {
           if ((lock.get(i) - lock.get(i + 1) + n) % n == 1) {
               index[i] = index[i + 1] = 0;
           }
       }
       for (i = 0; i < n; i++) {
           cnt += index[i];
       }
       for (i = 0; i < n && index[i] == 1; i++)
       for (; i < n && index[i] == 0; i++)
           
       x = n - 1;
       if (x == 0) {
           x = n;
       }
       Collections.rotate(lock, i);
       Collections.reverse(lock); // reverse 범위 지정하기.
       
       for (i = 0; lock.get(i) != n; i++) 
       if (i == n - 1) {
           i = -1;
       }
       System.out.printf("%d\n%d %d\n%d", n - i - 1, n - cnt + 1, n , x);
    }

}
