package Jennifersoft;

import java.util.Scanner;

/**
 * 김수겸
 * ikks06luck@gmail.com
 */

public class ProblemB {
    public static void main(String[] args) {
        //B번 문제의 접근 방법
        //1.두개의 for문과 랜덤변수(0,1)을 사용하여 임의의 남은 좌석 행렬을 만듭니다.
        //2.남은 좌석이 곧 전체 행렬의 희소행렬이므로 남은 좌석이 만들어지는 행과 열의 따로 만들어둔 행렬에 저장합니다.(1열 = 행, 2열 = 열)
        //3.희소행렬을 통해 커플좌석의 경우의 수를 구합니다.

        System.out.println("입력)");
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());

        if (input > 1000) {
            System.out.println("에잉 너무 길당");
        } else {
            int[][] sparseMetix = new int[input * input][2];    //희소행렬을 저장소를 만듭니다.
            int randomValue;    //남은 좌석과 찬 좌석을 구분할 랜덤변수
            int index = 0;  //희소행렬의 값을 저장할 때 필요한 행의 인덱스
            int seatCount = 0;  //커플좌석 카운트

            //1.
            for (int i = 0; i < input; i++) {
                for (int j = 0; j < input; j++) {
                    randomValue = (int) (Math.random() * 2);
                    if (randomValue == 0) { //랜덤변수가 0이면 남은 좌석
                        System.out.print('·');
                        //2.
                        //준비된 공간에 희소행렬의 행과 열을 저장합니다.
                        sparseMetix[index][0] = i;
                        sparseMetix[index][1] = j;
                        index++;
                    } else {    //랜덤변수가 1이면 찬 좌석
                        System.out.print('*' + " ");
                    }
                }
                System.out.println();
            }

            //3.
            for (int i = 1; i < sparseMetix.length; i++) {
                //sparseMetix[i - 1][1] : 직전 희소행렬의 열
                //sparseMetix[i][1] : 현재 희소행렬의 열
                //sparseMetix[i - 1][0] : 직전 희소행렬의 행
                //sparseMetix[i][0] : 직전 희소행렬의 열
                //현재 희소행렬과 직전 희소행렬의 행이 일치할 때
                //직전 희소행렬 열의 값 == 현재 희소행렬의 열의 값 -1(현재 열의 값에서 1을 뺀것이 직전 열의 값과 같다는 것은 직전 열과 현재 열이 붙어있다는 것을 의미)
                //을 찾아 붙어있는 좌석수를 카운트합니다.
                if (sparseMetix[i - 1][1] + 1 == sparseMetix[i][1] && sparseMetix[i - 1][0] == sparseMetix[i][0]) {
                    seatCount++;
                }
            }
            System.out.println("출력)");
            System.out.println(seatCount);
        }
    }
}
