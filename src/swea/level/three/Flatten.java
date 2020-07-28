package swea.level.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Flatten {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int dump;
        int[] wall;
        
        for (int test_case = 1; test_case <= 10; test_case++) {
            dump = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");
            wall = new int[arr.length];
            
            for (int i = 0; i < arr.length; i++) {
                wall[i] = Integer.parseInt(arr[i]);
            }
            
            // 오름차순 정렬 수행
            Arrays.sort(wall);
            
            // dump 수행
            int max = wall.length - 1;
            
            for (int i = 0; i < dump; i++) {
                wall[max] = wall[max] - 1;
                wall[0] = wall[0] + 1;
                
                int temp = 0;
                //최소값 갱신
                for (int j = 1; j < wall.length; j++) {
                    if (wall[0] <= wall[j]) {
                        temp = wall[0];
                        wall[0] = wall[j - 1];
                        wall[j - 1] = temp;
                        break;
                    }
                }
                
                //최대값 갱신
                for (int j = wall.length - 2; j > 0; j--) {
                    if (wall[max] >= wall[j]) {
                        temp = wall[wall.length - 1];
                        wall[max] = wall[j + 1];
                        wall[j + 1] = temp;
                        break;
                    }
                }
            } // end of dump
            
            System.out.println("#" + test_case + " " + (wall[max] - wall[0]));
            
        } // end of test_case
    } // end of main

} // end of class
