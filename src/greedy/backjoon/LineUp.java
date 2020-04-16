package greedy.backjoon;

import java.util.Scanner;
// 1138 한줄로 서기
public class LineUp {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[11];
        int n = sc.nextInt();
        int x;
        
        for (int i = 1; i <= n; i++) {
            x = sc.nextInt();
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (count == x && arr[j] == 0) {
                    arr[j] = i;
                    break;
                }
                if (arr[j] == 0) {
                    count++;
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            System.out.printf("%d ", arr[i]);
        }
        
        
        
    }

}
