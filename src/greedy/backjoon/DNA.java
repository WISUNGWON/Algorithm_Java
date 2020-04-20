package greedy.backjoon;

import java.util.Scanner;

// 1969 DNA
public class DNA {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] cArr = new char[N][M];
        String result = "";
        int count = 0;
        
        for (int i = 0; i < cArr.length; i++) {
            String str = sc.next();
            for (int j = 0; j < cArr[i].length; j++) {
                cArr[i][j] = str.charAt(j);
            }
        }
        
        for (int i = 0; i < M; i++) {
            int[] arr2 = new int[4];
            for (int j = 0; j < N; j++) {
                if (cArr[j][i] == 'A') {
                    arr2[0]++;
                }
                else if (cArr[j][i] == 'C') {
                    arr2[1]++;
                }
                else if (cArr[j][i] == 'G') {
                    arr2[2]++;
                }
                else {
                    arr2[3]++;
                }
                    
               
            }
            
            int max = arr2[0];
            int index = 0;
            
            for (int j = 1; j < arr2.length; j++) {
                if (arr2[j] > max) {
                    max = arr2[j];
                    index = j;
                }
            }
            
            if (index == 0) {
                result += 'A';
            }
            else if (index == 1) {
                result += 'C';
            }
            else if (index == 2) {
                result += 'G';
            }
            else {
                result += 'T';
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (result.charAt(j) != cArr[i][j]) {
                    count++;
                }
            }
        }
        System.out.println(result);
        System.out.println(count);
        sc.close();
    }

}
