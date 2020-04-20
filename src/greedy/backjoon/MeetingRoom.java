package greedy.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {

    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] tArr;
        int[][] arr = new int[N][2];
        
        for (int i = 0; i < arr.length; i++) {
            tArr = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(tArr[0]);
            arr[i][1] = Integer.parseInt(tArr[1]);
        }
        
        Arrays.sort(arr, new Comparator<int[]>( ) {

            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[1] == arr2[1]) {
                    return Integer.compare(arr1[0], arr2[0]);
                }
                return Integer.compare(arr1[1], arr2[1]);
            }
            
        });
        
        int maxMeeting = 0;
        int checkTime = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i][0] >= checkTime) {
                checkTime = arr[i][1];
                maxMeeting += 1;
            }
        }
        
        System.out.println(maxMeeting);
        br.close();
        
        
        
    }

}
