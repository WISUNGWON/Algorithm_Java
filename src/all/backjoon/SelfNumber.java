package all.backjoon;

// 4673 ¼¿ÇÁ³Ñ¹ö
public class SelfNumber {
    static final int N = 10001;
    static boolean[] arr = new boolean[N];
    
    static int solution(int n) {
        int sum = n;
        
        while(n != 0) {
            sum += n % 10;
            n = n / 10;
        }
        
        return sum;
    }
    public static void main(String[] args) {
        
        for (int i = 1; i < N; i++) {
            int idx = solution(i);
            if (idx < N) {
                arr[idx] = true;
            }
        }
        
        for (int i = 1; i < N; i++) {
            if (!arr[i]) {
                System.out.println(i);
            }
        }

    }

}
