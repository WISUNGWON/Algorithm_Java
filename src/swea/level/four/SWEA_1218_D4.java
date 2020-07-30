package swea.level.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218_D4 {
	
	static Stack<Character> st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		String str;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			T = Integer.parseInt(br.readLine());
			str = br.readLine();
			st = new Stack<Character>();
			
			int isSame = 1;
ex:			for (int i = 0; i < T; i++) {
				int c = str.charAt(i);
				if (isSame == 0) {
					System.out.println("#" + test_case + " " + isSame);
					break;
				}
				switch (c) {
				case '(':
					st.push('(');
					break;
				case '[':
					st.push('[');
					break;
				case '{':
					st.push('{');
					break;
				case '<':
					st.push('<');;
					break;
				case ')':
					if (st.pop() != '(') {
						isSame = 0;
						break ex;
					}
					break;
				case ']':
					if (st.pop() != '[') {
						isSame = 0;
						break ex;
					}
					break;
				case '}':
					if (st.pop() != '{') {
						isSame = 0;
						break ex;
					}
					break;
				case '>':
					if (st.pop() != '<') {
						isSame = 0;
						break ex;
					}
					break;
				}
			}

			System.out.println("#" + test_case + " " + isSame);
		}
		

	} // end of main

} // end of class
