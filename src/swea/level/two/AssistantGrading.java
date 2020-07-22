package swea.level.two;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 입력 2차원 배열 [1 ~ N + 1][3]
// 총점을 구해서
// 쭉 ~ 해서 10개의 평가를한다.
// 세 점수를 받는 배열
// 각 배열의 총점을 구하기
// K번 째 애의 점수 따놓기
// 오름차순으로 정렬해서 그 중에 K번째 애랑 매칭하기
// 몇번째인지와 N이 몇개였는지에 따라서 학점 출력하기.

// 1983 조교의 성적 매기기
public class AssistantGrading {
    
    static int T, N, K, rank;
    static double[] scoreArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            String[] arr = br.readLine().split(" ");
            N = Integer.parseInt(arr[0]); // 학생수
            K = Integer.parseInt(arr[1]); // 알고싶은 번째 학생
            
            // ------ 총점 저장
            scoreArr = new double[N];
            for (int i = 0; i < N; i++) {
                arr = br.readLine().split(" ");
                scoreArr[i] = Integer.parseInt(arr[0]) * 0.35 + Integer.parseInt(arr[1]) * 0.45 + Integer.parseInt(arr[2]) * 0.2;
                // (f) 정수연산이 빠름
            }
            
            
            // ------- 랭킹 구하기
            double kScore = scoreArr[K - 1];
            rank = 0; // (f) 0으로 만드는게 핵심
            for (int i = 0; i < scoreArr.length; i++) {
                if (scoreArr[i] > kScore) {
                    rank++;
                }
            }
            
            // ------- 학점 부여하기
            int dup = N / 10; // 몇명의 학생이 동일한 평점인지 구하기.      
            
            String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
            
            bw.write("#" + test_case + " " + grade[rank / dup] + "\n");
        } // end of for 
        
        br.close();
        bw.flush();
        bw.close();
        
        
    } // end of main
    // 1. 총점을 구하고, 자기가 몇등인지 알아야 한다.
        
    
} // end of class

