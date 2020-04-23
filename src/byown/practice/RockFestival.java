package byown.practice;

import java.util.Scanner;

public class RockFestival {
    
    static int[] summation;

    public static void main(String[] args) {
        int case_num, total_num = 0, least_len = 0, i, j, k, len, sum;
        int[] arr;
        double min, current;
        
        Scanner sc = new Scanner(System.in);
        
        case_num = sc.nextInt();
        
        for (i = 0; i < case_num; i++) {
            total_num = sc.nextInt();
            least_len = sc.nextInt();
            arr = new int[total_num];
            summation = new int[total_num + 1];
            summation[0] = 0;
            for (j = 0; j < total_num; j++) {
                arr[j] = sc.nextInt();
                summation[j + 1] = summation[j] + arr[j];
            }
        
        
            min = 999999999;
            int start, end;
            for (start = 0; start <= total_num - least_len; start++) {
                for (end = start + least_len; end <= total_num; end++) {
                    current = (double)(summation[end] - summation[start]) / (end-start);
                    System.out.println(current);
                    if (min > current) {
                        min = current;
                        System.out.println("min is : " + min);
                    }
                }
            }
            System.out.printf("%.10f\n", min);
        }
        
        
        
        sc.close();

    }

}
