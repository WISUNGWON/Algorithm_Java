package all.backjoon;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class PostfixExpression2NoMap {
    
    static Stack<Double> stack = new Stack<Double>();
    static char ch;
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        char[] s = sc.next().toCharArray();
        int len = s.length;
        double[] array = new double[n]; // 알파벳과 매칭될 숫자를 저장하는 배열
        
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        
        for (int i = 0; i < len; i++) { // 연산자면 연산, 기본적으로는 스택에 숫자 넣기
            ch = s[i];
            
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                calculate(stack.pop(), stack.pop());
                continue;
            } else {
                stack.push(array[ch - 'A']);
                continue;
            }
        }
        
        System.out.printf("%.2f", stack.peek());
    } // end of main
    
    static void calculate(Double a, Double b) {
        
        switch (ch) {
            case '+':
                stack.push(b + a);
                break;
            case '-':
                stack.push(b - a);
                break;
            case '*':
                stack.push(b * a);
                break;
            case '/':
                stack.push(b / a);
                break;
        }
    }

} // end of class
