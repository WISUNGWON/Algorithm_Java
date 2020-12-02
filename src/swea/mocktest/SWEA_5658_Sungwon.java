package swea.mocktest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SWEA_5658_Sungwon {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
		
		
		char[] charArr = br.readLine().toCharArray();
		int sliceNum = charArr.length / 4;
		char[] charScliceArr = new char[sliceNum];
		
		TreeSet<Integer> treeSet = new TreeSet<Integer>(new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		for (int i = 0, j = 0; i < 4; i++, j += sliceNum) {
			for (int j2 = 0; j2 < sliceNum; j2++) {
				charScliceArr[j2] = charArr[j + j2];
			}
			String concatStr = new String(charScliceArr);
			treeSet.add(Integer.parseInt(concatStr, 16));
		}
		
		
		// lotate실행 
		for (int i = 0, j = charArr.length - 1; i < sliceNum - 1; i++, j--) {
			// locate후 slice
			for (int i2 = 0, j2 = j; i2 < 4; i2++, j2 += sliceNum) {
//				if (j2 > charArr.length - 1) {
//					j2 = j2 - charArr.length - 1;
//				}
				for (int k = 0; k < sliceNum; k++) {
					if (j2 + k > charArr.length - 1) {
						j2 = j2 - (charArr.length);
					}
					charScliceArr[k] = charArr[j2 + k];
				}
				String concatStr = new String(charScliceArr);
				treeSet.add(Integer.parseInt(concatStr, 16));
			}
		}
		
		Object[] arr = treeSet.toArray();
		sb.append("#").append(test_case).append(" ").append(arr[K - 1]).append("\n");
		} // end of TC
		System.out.println(sb);
	} // end of Main
} // end of class
