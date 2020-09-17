package swea.level.three;

import java.util.Scanner;

// SWEA D3 원재의 메모리 복구
public class SWEA_1289_MemoryRestore {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String memory = sc.next();
			char head = '0';
			int cnt = 0;
			for (int i = 0; i < memory.length(); i++) {
				if (memory.charAt(i) != head) {
					cnt++;
					head = memory.charAt(i);
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
		} // end of TC
		System.out.println(sb);
	} // end of main
} // end of class
