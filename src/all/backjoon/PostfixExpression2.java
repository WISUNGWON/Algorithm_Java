package all.backjoon;

import java.util.LinkedList;
import java.util.Scanner;

// 입력받은 알파벳 및 연산자 숫자로 대응하기
// 스택 구현하기(Integer)
// 구현한 스택으로 후위표기식 연산하기

// 스택 구현하기
class StackC {
    
    private static StackC stackC = new StackC(); 
    
    private static LinkedList<Float> arrC = new LinkedList<Float>();
    
    private StackC() {}
    
    public static StackC getInstance() {
        return stackC;
    }
    
    public void push (Float item) { // Pushes an item onto the top of this stack.
        arrC.addFirst(item);
    }
    
    public Float pop() {
        return arrC.removeFirst();
    }
    
    public Float get(int index) {
        return arrC.get(index);
    }
    
}
public class PostfixExpression2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N;
        
        StackC stackC = StackC.getInstance();
        char[] pe, operators; // pe : 후위표기식 입력받는 배열, operators : 연산자 저장하는 배열
        float[] numArr;
        float[] numLast;
        
        // 입력부
        N = sc.nextInt(); // N 입력받기
        pe = sc.next().toCharArray(); // 후위표기식 입력받음
        numArr = new float[N]; // 숫자 입력받음
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = sc.nextFloat();
        }
       

        /* 아스키 코드 표
         * 42 = * ---> 1003
         * 43 + ----> 1001
         * 45 - ----> 1002
         * 47 / -----> 1004
         * A = 65, Z = 90
         * 0 = 48, 9 = 57
         */
        
        numLast = new float[pe.length];
        
        // 입력받은 알파벳에 숫자 및 연산자 대응하기
        // pe의 알파벳 요소를 숫자로 바꾸기
        int cnt = 0;
        for (int i = 0; i < pe.length; i++) {
            if (pe[i] >= 65 && pe[i] <= 90) {
                numLast[i] = numArr[cnt++];
            } else if (pe[i] == '+') {
                numLast[i] = 1001f;
            } else if (pe[i] == '-') {
                numLast[i] = 1002f;
            } else if (pe[i] == '*') {
                numLast[i] = 1003f;
            } else if (pe[i] == '/') {
                numLast[i] = 1004f;
            }
        }
        
        
        // 구현한 스택으로 후위표기식 연산하기
        float a, b;
        for (int i = 0; i < numLast.length ; i++) {      
            if (numLast[i] == 1001f) {
                a = stackC.pop();
                b = stackC.pop();
                stackC.push(b + a);
                continue;
            } else if (numLast[i] == 1002f) {
                a = stackC.pop();
                b = stackC.pop();
                stackC.push(b - a);
                continue;
            } else if (numLast[i] == 1003f) {
                a = stackC.pop();
                b = stackC.pop();
                stackC.push(b * a);
                continue;
            } else if (numLast[i] == 1004f) {
                a = stackC.pop();
                b = stackC.pop();
                stackC.push(b / a);
                continue;
            }
            stackC.push(numLast[i]);
        }
        
        System.out.printf("%.2f", stackC.get(0));


        
    } // end of main
    
    //스택 구현하기
    

} // end of class
