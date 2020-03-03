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
            //1) N을 2진수로 바꾸고 각 2진수를 배열에 담는다.
            for (int i = arrNum.length - 1; i >= 0; i--) {
                arrNum[i] = N % 2;
                N = N / 2;
            }
            
            //2) binaryGap 탐색
            for (int i = 0; i < arrNum.length; i++) {
                    if (arrNum[i] == 1) {
                        for (int j = i + 1; j < arrNum.length; j++) {
                            if (arrNum[j] == 0) {
                                biCut = biCut + 1;
                                if (j == arrNum.length - 1 && arrNum[j] == 0) { //0값으로 끝날경우 bitCut을 0으로.
                                    biCut = 0;
                                    if (i == 0) { //0값으로 끝날경우 bitCut을 0으로.
                                        result = biCut;
                                    }

                                }
                            }

                            if (biCut > result) { //각 binaryGab 시행마다 가장 큰 값을 result에 보관.
                                result = biCut;
                            }
                            
                            if (arrNum[j] == 1) {
                                i = j - 1; // for에서 i++을 하기 때문에.
                                j = arrNum.length;
                                biCut = 0;
                            }  
                           
                        }
                       
                    }
                }
                    
               
            // 3) 결과 반환
            return result;
      }
    }