package Jennifersoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ksk on 2016-04-16.
 */


public class ProblemE {
    public static void main(String[] args) {
        System.out.println("입력)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Boolean caseConfirm = false;

        for (int i = 0; i < input.length(); i++) {
            if ((int) input.charAt(i) < 65 || (int) input.charAt(i) > 90) {
                caseConfirm = true;
            }
        }

        if (input.length() > 1000 || caseConfirm) {
            System.out.println("너무 길거나 대문자가 아니에요");
        } else {

        }
    }
}
