package Tree;


import Matrix.Matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ksk on 2016-04-20.
 */
public class BinaryTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int limitedW;
        int totalW = 0;
        while (number-- > 0) {
            limitedW = scanner.nextInt();
            for (int i = 0; i < 9; i++) {
                totalW += scanner.nextInt();
            }
            if (limitedW >= totalW) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            totalW = 0;
        }
    }
}
