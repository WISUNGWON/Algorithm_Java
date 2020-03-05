package codility.practice;


public class PermMissingElem {
    public static void main(String[] args) {
        int[] test = {1,3,4,5};
        System.out.println(solution(test));
        
    }
    
    public static int solution(int[] data)  {
        
        long N = data.length + 1;
        long total = (N * (N + 1)) / 2;
        long sum = 0;
        for(int i : data) {
            sum += i;
        }
        
        return (int)(total - sum);
    }
    

}
