package swea.level.four;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PossibleTestScore {


    static int T, N, num, sum, answer;
    static int array[];
    static boolean check[];


    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    static StringTokenizer stringTokenizer;


    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(bufferedReader.readLine());
            array = new int[N];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                num = Integer.parseInt(stringTokenizer.nextToken());
                array[j] = num;
                sum += num;
            }

            check = new boolean[sum + 100];
            check[0] = true;
            answer = 0;
            for (int j = 0 ; j < N; j++){

                for (int k = sum; k >= 0; k--){
                    if (check[k]){
                        check[k+array[j]] = true;
                    }
                }
            }

            for (int j = 0 ; j < sum + 100; j++){
                if (check[j]){
                    answer++;
                }
            }

            bufferedWriter.write("#" + (i + 1) + " " + answer + "\n");

        }
        bufferedWriter.flush();

    }
}
