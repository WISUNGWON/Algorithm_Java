package recursive.beakjoon;

import java.util.Scanner;

public class Beakjoon_15650 {

    private static int N;
    private static int[] numbers;
    private static StringBuilder sb;
    private static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt(); // 
        M = sc.nextInt(); // 
        numbers = new int[M];
        combination(0, 1);
        System.out.println(sb);

    } // end of main

    private static void combination(int cnt, int start) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = start; i <= N; i++) {
                numbers[cnt] = i;
                combination(cnt + 1, i + 1);
            }
        }   // end of method permutation
    } 

