package codility.practice;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int[] arr = {9, 4, 9, 4, 7, 9, 9, 4, 4};
        System.out.println(solution(arr));
        System.out.println(9 ^ 15);
    }
    
    public static int solution(int[] A) {
        int answer = 0;
        for(int num : A) {
            answer ^= num;
        }
        return answer;
    } 
}
