package recursive.beakjoon;

import java.util.Scanner;

public class Beakjoon_10974 {

    private static int N;
    private static int[] numbers;
    private static boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt(); // 
        numbers = new int[N];
        visited = new boolean[N + 1];
        permutation(0);
        System.out.println(sb);

    } // end of main

    private static void permutation(int cnt) {
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            } else {
                numbers[cnt] = i;
                visited[i] = true;
                permutation(cnt + 1);
                visited[i] = false;
            }
        }   
    } // end of method permutation
} // end of class
