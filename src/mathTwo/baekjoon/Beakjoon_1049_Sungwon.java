package mathTwo.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon_1049_Sungwon {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int minI = Integer.MAX_VALUE;
		int minP = Integer.MAX_VALUE;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int item = Integer.parseInt(st.nextToken());
			
			if (minP > p) {
				minP = p;
			}
			if (minI > item) {
				minI = item;
			}
		}
		
		if (minP > minI * 6) {
			minP = minI * 6;
		}
		
		int m = N / 6;
		int l = N % 6;
		
		if (l * minI > minP) {
			System.out.println(minP * (m + 1));
		} else {
			System.out.println(minP * m + minI * l);
		}
	} // end of main

}
