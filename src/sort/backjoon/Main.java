package sort.backjoon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String name;
        int age;
       
        System.out.println("Enter your age");
        age = sc.nextInt();
        System.out.println("Enter your name");
        name = sc.nextLine();
        
        System.out.printf("나이는 %d 입니다. %n", age);
        System.out.printf("이름은 %s 입니다. %n", name);
        System.out.println(name);
        
        sc.close();
        
        
        
        
   
     } 
}

