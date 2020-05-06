package dp2.backjoon;

//���� 11054 ������� �ٸ� Ǯ��
import java.util.Scanner;

public class BitonicDesc {
    
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        int asc[] = new int[n];
        int desc[] = new int[n];
        
        for(int i = 0; i< n; i++) {
            asc[i] = 1;
            for(int j = 0; j < i; j++) {
                if(a[j] < a[i] && asc[i] <= asc[j])
                    asc[i] = asc[j] + 1;
            }
        }
        for(int i = n - 1; i >= 0; i--) {
            desc[i] = 1;
            for(int j = n - 1; j > i; j--) {
                if(a[j] <a[i] && desc[i] <= desc[j]) {
                    desc[i] = desc[j] + 1;
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, asc[i] + desc[i]);
        }
        System.out.println(max - 1);
        
    }
}
