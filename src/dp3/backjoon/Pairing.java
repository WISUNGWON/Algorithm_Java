package dp3.backjoon;

import java.util.Scanner;

//2599 Â¦Á¤ÇÏ±â
public class Pairing {
    static int[] m = new int[3];
    static int[] w = new int[3];
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for (int i = 0; i < 3; i++) {
            m[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        
        for (int i = 0; i <= m[0]; i++) {
            if (i > w[1]) {
                break;
            }
            for (int j = 0; j <= m[1]; j++) {
                if (j > w[0]) {
                    break;
                }
                if (w[2] - (m[0] - i) - (m[1] - j) == 0) {
                    System.out.printf("1\n");
                    System.out.printf("%d %d\n", i, m[0] - i);
                    System.out.printf("%d %d\n", j, m[1] - j);
                    System.out.printf("%d %d\n", w[0] - j, w[1] - i);
                }
            }
        }

    }

}
