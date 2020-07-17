package swea.level.four;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 세운이는 내일 할거야
public class SaewoonDoItTomorrow {
    
    static PriorityQueue<int[]> assignments = new PriorityQueue<>(new Comparator<int[]>() {
        
        public int compare(int[] i1, int[] i2) {
            return i2[1] - i1[1]; //1번째 요소가 큰놈이 양수가 되므로 우선순위!
        }
    });
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int t, d;
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            assignments.clear();
            
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                t = Integer.parseInt(st.nextToken()); //걸리는 시간
                d = Integer.parseInt(st.nextToken()); // 마감 기한
                assignments.add(new int[] {t, d});
            }
                        
            //poll : 큐 맨앞 요소 반환 후 큐에서 제거
            int assignment[] = assignments.poll(); //D가 가장 큰놈 첫번째로 뽑기
            int startTime = assignment[1] - assignment[0]; //D가 가장 큰놈의 X값 구하기
            while (!assignments.isEmpty()) { //알고리즘 부분. (왜 이렇게 나왔는지 고민하기)
                assignment = assignments.poll();
                if (startTime < assignment[1]) {
                    startTime -= assignment[0];
                } else {
                    startTime = assignment[1] - assignment[0];
                }
                
                bw.write("#" + test_case + " " + startTime + "\n");
                    
            }
                
             
        }

    }

}
