package sort.backjoon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        String s1 = new String("hello");

        String s2 = new String("hello");
        
        String s3 = "hello";
        
        String s4 = "hello";
        
        String s5 = s1;
        
        //상수 풀의 존재
        
        if(s1 == s2) System.out.println("s1과 s2 주소값이 같음");
        
        if(s2 == s3) System.out.println("s2과 s3 주소값이 같음");
        
        if(s3 == s4) System.out.println("s3과 s4 주소값이 같음");
        
        if(s3 == s4) System.out.println("s5과 s1 주소값이 같음");
        
        if(s1.equals(s2)) System.out.println("s1과 s2 객체 내용이 같음");
        
        if(s1.equals(s3)) System.out.println("s1과 s3 객체 내용이 같음");
        
        
        
        
   
     } 
}

