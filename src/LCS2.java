import java.util.Scanner;
public class LCS2 {
    private static StringBuffer sb;
    private static int[][] map;
    private static String s1;
    private static String s2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuffer();
        s1 = sc.next();
        s2 = sc.next();
        int cnt = 0;
        map = new int[s1.length() + 1][s2.length()+ 1];
        for (int i = 1; i <= s1.length(); i++) {
            char ch1 = s1.charAt(i - 1);
            for (int j = 1; j <= s2.length(); j++) {
                char ch2 = s2.charAt(j - 1);
                if (ch1 == ch2) {
                    map[i][j] = map[i - 1][j - 1] + 1;
                    if (map[i - 1][j - 1] + 1 > cnt) {
                        cnt++;
                    }
                } else {
                    map[i][j] = Math.max(map[i][j - 1], map[i - 1][j]);
                }
            }
        }
        
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
       
       findLetter(s1.length(), s2.length());
        System.out.println(map[s1.length()][s2.length()]);
        System.out.println(sb);
    } // end of main

    // 왼쪽 위 대각선, 왼쪽 탐색
    private static void findLetter(int row, int col) {
        if (map[row][col] == 0) { // 대각선이 0이면 탐색 종료
            sb.insert(0, s2.charAt(col - 1));
            return;
        }
        if (map[row][col] == map[row][col - 1]) {
            int nr = row; // 좌측으로 쭉 찾기 
            int nc = col;
            while(true) { // 좌측에 -1크기를 찾을 때 까지 왼쪽으로 이동
                if (map[nr][nc - 1] == map[nr][nc] - 1) { // 찾았으면
                    if (nr - 1 < 0 || nc - 1 < 0)
                    {
                        sb.insert(0, s2.charAt(nc - 1));
                        findLetter(nr, nc);
                        
                        return;
                    } else {
                        sb.insert(0, s2.charAt(nc - 1));
                        findLetter(nr - 1, nc - 1);

                        return;
                    }

                }
                nc--;
            }
        }
        else if (map[row - 1][col - 1] == map[row][col] - 1) {
            int nr = row - 1; // 해당 대각선 위치로 이동후 작을 값을 찾을 때 까지 왼쪽으로 이동 수행 
            int nc = col - 1;
            while(true) { // 좌측에 -1크기를 찾을 때 까지 왼쪽으로 이동
                if (map[nr][nc - 1] == map[nr][nc] - 1) { // 찾았으면
                    if (nr - 1 < 0 || nc - 1 < 0)
                    {
                        findLetter(nr, nc);
                        sb.insert(0, s2.charAt(nc - 1));
                        return;
                    } else {
                        findLetter(nr - 1, nc - 1);
                        sb.insert(0, s2.charAt(nc - 1));
                        return;
                    }
                }
                nc--;
            }
        } else { // 같은 경우
            findLetter(row - 1, row - 1);
            return;
        }
    }
} // end of class