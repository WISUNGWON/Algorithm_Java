package byown.practice;

import java.util.Scanner;

public class PondStriderJump {
    static int cnt;
    static int N, num;
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수
        for (int testCase = 1; testCase <= T; testCase++) {
            N = sc.nextInt(); // 배열의 크기 N*N
            int[][] lake = new int[N][N]; // 호수

            num = sc.nextInt(); // 소금쟁이(Strider)수
            int[][] strider = new int[num][3]; // 행, 열, 방향 저장

            for (int k = 0; k < num; k++) {
                strider[k][0] = sc.nextInt();// 행위치
                strider[k][1] = sc.nextInt();// 열위치
                strider[k][2] = sc.nextInt();// 방향(상:1, 하:2, 좌:3, 우:4)
            }

            cnt = 0; // 연못에 살아있는 소금쟁이 개수
ex:         for (int k = 0; k < num; k++) { // 소금쟁이 개수만큼 반복
                int row = strider[k][0]; // 시작 위치 행
                int col = strider[k][1]; // 시작 위치 열
                int dir = strider[k][2]; // 방향

                if (row >= 0 && row < N && col >= 0 && col < N) { // 배열벗어나지 않는지 체크
                    if (lake[row][col] == 1) // 세번뛴 소금쟁이가 도착한 자리라면
                        continue ex; // 현재 소금쟁이는 죽음, 다음 소금쟁이로 넘어가기 
                    if (dir == 1) { // 1.상
                        for (int i = 3; i >= 1; i--) { // i : 점프 뛸 칸 수
                            row = row - i;
                            if (0 <= row) {// 3칸
                                if (lake[row][col] == 1) { // 세번뛴 소금쟁이가 도착한 자리라면
                                    continue ex; // 현재 소금쟁이는 죽음, 다음 소금쟁이로 넘어가기 
                                }
                            } else { // 배열의 범위를 이미 벗어났다면
                                continue ex; // 소금쟁이 죽음, 다음 소금쟁이로 넘어가기
                            }
                        }
                        lake[row][col] = 1; // 연못안에 남아있는 소금쟁이 흔적
                        cnt++;
                    } else if (dir == 2) { // 2.하
                        for (int i = 3; i >= 1; i--) { // i : 점프 뛸 칸 수
                            row = row + i;
                            if (row < N) {// 3칸
                                if (lake[row][col] == 1) { // 세번뛴 소금쟁이가 도착한 자리라면
                                    continue ex; // 현재 소금쟁이는 죽음, 다음 소금쟁이로 넘어가기 
                                }
                            } else { // 배열의 범위를 이미 벗어났다면
                                continue ex; // 소금쟁이 죽음, 다음 소금쟁이로 넘어가기
                            }
                        }
                        lake[row][col] = 1; // 연못안에 남아있는 소금쟁이 흔적
                        cnt++;
                    } else if (dir == 3) { // 3.좌
                        for (int i = 3; i >= 1; i--) {
                            col = col - i;
                            if (0<=col) { // 3칸
                                if (lake[row][col] == 1) { // 세번뛴 소금쟁이가 도착한 자리라면
                                    continue ex; // 현재 소금쟁이는 죽음, 다음 소금쟁이로 넘어가기 
                                }
                            } else { // 배열의 범위를 이미 벗어났다면
                                continue ex; // 소금쟁이 죽음, 다음 소금쟁이로 넘어가기
                            }
                        }
                        lake[row][col] = 1; // 연못안에 남아있는 소금쟁이 흔적
                        cnt++;
                    } else if (dir == 4) { // 4.우
                        for (int i = 3; i >= 1; i--) {
                            col = col + i;
                            if (col < N) { // 3칸
                                if (lake[row][col] == 1) { // 세번뛴 소금쟁이가 도착한 자리라면
                                    continue ex; // 현재 소금쟁이는 죽음, 다음 소금쟁이로 넘어가기 
                                }
                            } else { // 배열의 범위를 이미 벗어났다면
                                continue ex; // 소금쟁이 죽음, 다음 소금쟁이로 넘어가기
                            }
                        }
                        lake[row][col] = 1; // 연못안에 남아있는 소금쟁이 흔적
                        cnt++;
                    }
                }
            } // for ex
            System.out.println("#" + testCase + " " + cnt);
        } // end of for
    } // end of main
} // end of class

