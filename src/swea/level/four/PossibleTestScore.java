package swea.level.four;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//3752. 가능한 시험 점수 (여기까지 30분 푼 것)
public class PossibleTestScore {

    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int test_case, N, sum, a, b;
        String[] strArr;
        Set<Integer> ansSet = new HashSet<Integer>(); //답 저장하기
        
        test_case = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= test_case; i++) {
            ansSet.clear();
            N = Integer.parseInt(br.readLine());
            strArr = br.readLine().split(" ");
            sum = 0;
            System.out.println(Arrays.toString(strArr));
            for (int j = 0; j < strArr.length; j++) {
                ansSet.add(Integer.parseInt(strArr[j]));
                sum = sum + Integer.parseInt(strArr[j]);
            }
            
            //디버그
            Iterator<Integer> iter = ansSet.iterator();
            while (iter.hasNext()) {
                System.out.println("iterator : " + iter.next());
            }
            System.out.println("sum : " + sum);
            //여기까지 
            
            ansSet.add(sum);
            
            for (int j = 0; j < strArr.length - 1; j++) {
                a = Integer.parseInt(strArr[j]);
                    for (int z = j + 1; z < strArr.length; z++) {
                        b = Integer.parseInt(strArr[z]); // 여기서 오류가 있다 DP로 풀어야 할듯 1,1,1,1,경우 계속 2를 합한다. 이전 값에서 더해야되는데.
                        ansSet.add(a + b);
                    }
            }
            
            //디버그
            while (iter.hasNext()) {
                System.out.println("iterator : " + iter.next());
            } // 여기까지
            
            bw.write("#" + i + " " + ansSet.size() + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();

    }

}
