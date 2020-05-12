package mathOne.baekjoon;

// 1193 분수찾기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class SearchingFraction {
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        
        int i = 0; // 해당칸을 시작하는 분모 or 분자 값 (ex i = 3 이면 1/3 또는 1/3)
        int sum = 0; // n - sum은 n위치의 분모 or 분자 값.
        while (i + sum < n) { 
            sum += i++;
        }
        // 분자 + 분모 값은 i + 1
        int a = 0;
        if (i % 2 == 0) { // 짝수면 a / b
            a = n - sum;
        } else {
            a= i + 1 - (n - sum); // 홀수면 b / a
        }
        
        int b = i + 1 - a;
        
        System.out.println(a + "/" + b);
        br.close();
       
    }
}

/* 1. 홀수 , 짝수 칸일때 마다 내려가는지 위로가는지 규칙 도출가능
 * 2. 각 칸의 분모 + 분자의 합은 일정하다는 규칙 도출 가능
 * 3. n번째의 분자 또는 분모의 값은 n - n번째 이전 칸의 수 도출 가능*/

