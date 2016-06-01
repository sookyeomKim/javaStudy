package AlgorithmStudy;

import java.util.Scanner;

/**
 * Created by ksk on 2016-06-02.
 */
public class RoomMirrors {
    private static int changeDirection(int direction, int kindOfmirror) {
        //0 : 아래, 1 : 위, 2 : 오른쪽, 3 : 왼쪽
        if (kindOfmirror == 1) {
            return 3 - direction;
        } else {
            return (direction + 2) % 4;
        }
    }

    private static void applyAlgorithm(int[][] gridMatrix, int gridCount, int startRow, int startCol, int startDirection) {
        int[] reflectionRow = {1, -1, 0, 0};
        int[] reflectionCol = {0, 0, 1, -1};
        int row = startRow, col = startCol, direction = startDirection, distance = 0;
        boolean[][] reflectionConfirm = new boolean[gridCount][gridCount];

        while (0 <= row && row < gridCount && 0 <= col && col < gridCount) {
            if (gridMatrix[row][col] != 0) {
                distance++;
                reflectionConfirm[row][col] = true;
                direction = changeDirection(direction, gridMatrix[row][col]);
            }
            row += reflectionRow[direction];
            col += reflectionCol[direction];
        }

        for (int j = 0; j < gridCount; j++) {
            for (int k = 0; k < gridCount; k++) {
                System.out.print(reflectionConfirm[j][k] + " ");
            }
            System.out.println();
        }

        System.out.print("이동한 거울 개수 :" + distance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("격자 개수");
        int gridCount = scanner.nextInt();
        System.out.println("놓여질 거울 개수");
        int mirrosCount = scanner.nextInt();
        System.out.println("진입할 격자 위치");
        int startCol = scanner.nextInt();
        int startRow = scanner.nextInt();
        System.out.println("레이저 방향");
        int startDirection = scanner.nextInt();
        int[][] gridMatrix = new int[gridCount][gridCount];

        for (int j = 0; j < gridCount; j++) {
            for (int k = 0; k < gridCount; k++) {
                gridMatrix[j][k] = 0;
            }
            System.out.println();
        }

        for (int i = 0; i < mirrosCount; i++) {
            System.out.println("거울의 위치를 입력해주세요");
            int lcationX = scanner.nextInt();
            int lcationY = scanner.nextInt();
            int kindOfMirror = scanner.nextInt();
            gridMatrix[lcationX][lcationY] = kindOfMirror;
        }

        System.out.println("거울의 위치");
        for (int j = 0; j < gridCount; j++) {
            for (int k = 0; k < gridCount; k++) {
                System.out.print(gridMatrix[j][k] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------");

        applyAlgorithm(gridMatrix, gridCount, startRow, startCol, startDirection);
    }
}
