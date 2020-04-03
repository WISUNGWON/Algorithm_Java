package codility.practice;

import java.util.Arrays;
import java.util.Scanner;

public class BinaryGap {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int testN = sc.nextInt();
        System.out.println("result : " + solution(testN));
        

    }
    

        public static int solution(int N) {
            int result = 0;
            int biCut = 0;
            String bi = Integer.toBinaryString(N);
            
            int[] arrNum = new int[bi.length()];
            //1) 노드안녕 
            for (int i = arrNum.length - 1; i >= 0; i--) {
                arrNum[i] = N % 2;
                N = N / 2;
            }
            
            //2) binaryGap
            for (int i = 0; i < arrNum.length; i++) {
                    if (arrNum[i] == 1) {
                        for (int j = i + 1; j < arrNum.length; j++) {
                            if (arrNum[j] == 0) {
                                biCut = biCut + 1;
                                if (j == arrNum.length - 1 && arrNum[j] == 0) { 
                                    biCut = 0;
                                        result = biCut;
                                    }

                                }
                            }

                            if (biCut > result) { 
                                result = biCut;
                            }
                            
                            if (arrNum[j] == 1) {
                                i = j - 1; 
                                j = arrNum.length;
                                biCut = 0;
                            }  
                           
                        }
                       
                    }
                }
                    
              
            return result;
      }
    }