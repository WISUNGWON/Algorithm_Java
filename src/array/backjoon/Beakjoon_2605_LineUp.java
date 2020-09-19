package array.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Beakjoon_2605_LineUp {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int studentNum = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for (int i = 0; i < studentNum; i++) {
			int pickedNum = Integer.parseInt(st.nextToken());
			arrList.add(i - pickedNum, i + 1);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int a : arrList) {
			sb.append(a + " ");
		}
		
		System.out.println(sb);
	} // end of main
}
