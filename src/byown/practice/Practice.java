package byown.practice;

import java.util.Arrays;

public class Practice {
	public static void main(String[] args) {
		
		String key = "Hello";
		
		char[] ch = key.toCharArray();
		System.out.println(Arrays.toString(ch));
		int hash = 0;
		for (int i = 0; i < key.length(); i++) {
			hash = hash * 31 + ch[i];
		}
		System.out.println(hash);
	}
}
