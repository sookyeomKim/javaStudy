package AlgorithmStudy;

import java.util.Scanner;

/**
 * Created by ksk on 2016-06-01.
 */
public class FrogJump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("돌 갯수");
        int stonesCount = scanner.nextInt();
        int[] stones = new int[stonesCount];
        for (int i = 0; i < stonesCount; i++) {
            System.out.println("돌 위치");
            stones[i] = scanner.nextInt();
        }
        System.out.println("개구리 점프력");
        int maximumJumpDistance = scanner.nextInt();

        int currentPosition = stones[0];
        int jumpCount = 0;
        for (int i = 1; i < stones.length; i++) {
            if (currentPosition + maximumJumpDistance < stones[i]) {//현재 위치와 최대 점프거리의 합이 돌[i]의 위치보다 작을 경우 돌[i-1]의 위치로 점프
                if (currentPosition + maximumJumpDistance >= stones[i - 1]) {//최대 점프거리보다 돌[i-1]의 위치가 더 멀리 있으면 못 뛰고 아니면 뛰고
                    if (currentPosition != stones[i - 1]) {//현재 위치와 돌[i-1]의 위치가 같으면 가만히 있고 아니면 돌[i-1]로 뛰고
                        currentPosition = stones[i - 1];
                        jumpCount++;
                    }
                } else {
                    System.out.println("더 이상 점프를 할 수 없습니다.");
                    break;
                }
            }

            //맨 마지막 돌로 뛰기 위한 처리
            if (stones.length - 1 == i) {
                if (currentPosition + maximumJumpDistance >= stones[i]) {
                    currentPosition = stones[i];
                    jumpCount++;
                } else {
                    System.out.println("더 이상 점프를 할 수 없습니다.");
                }
            }
        }
        System.out.println("현재 위치 : " + currentPosition);
        System.out.println("점프 횟수 : " + jumpCount);
    }
}
