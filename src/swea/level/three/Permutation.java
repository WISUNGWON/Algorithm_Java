package swea.lever.three;

import java.util.Scanner;

// ����1 9940
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

// ���� : ���� �ٸ� n�� �߿��� r���� ���Ͽ� �Ϸķ� �迭�ϴ� ��� ex 5P3
