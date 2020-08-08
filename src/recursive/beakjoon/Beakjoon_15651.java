package recursive.beakjoon;

import java.util.Scanner;

public class Beakjoon_15651 {

    private static int N;
    private static int[] numbers;
    private static StringBuilder sb;
    private static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt(); // 
        M = sc.nextInt(); // 
        numbers = new int[N];
        permutation(0);
        System.out.println(sb);

    } // end of main

    private static void permutation(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 1; i <= N; i++) {
                numbers[cnt] = i;
                permutation(cnt + 1);
        }   
    } // end of method permutation
} // end of class
