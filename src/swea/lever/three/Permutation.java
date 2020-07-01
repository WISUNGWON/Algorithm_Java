package swea.lever.three;

import java.util.Scanner;

// 순열1 9940
public class Permutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int test;
        String ans ="Yes";
        boolean[] check;
        int i = 0;
        test = sc.nextInt();
        
        while (i < test) {
            int N = sc.nextInt();
            check = new boolean[N];
            for (int j = 0; j < N; j++) {
                int num = sc.nextInt();
                check[num - 1] = true;
            }
            
            for (int j =0; j < N; j++) {
                if (!check[j]) {
                    ans = "No";
                    break;
                }
            }
            
            i++;
            System.out.println("#" + i + " " + ans);
        }
        
        sc.close();
    }

}

// 순열 : 서로 다른 n개 중에서 r개를 택하여 일렬로 배열하는 경우 ex 5P3
