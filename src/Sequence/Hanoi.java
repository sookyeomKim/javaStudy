package Sequence;

/**
 * Created by ksk on 2016-06-01.
 */
public class Hanoi {
    private static void Hanoi(int n, int from, int by, int to) {
        if (n == 1) {
            System.out.println(from + "번 기둥에서" + to + "번 기둥으로 옮긴다.");
        } else {
            Hanoi(n - 1, from, to, by);
            System.out.println(from + "번 기둥에서" + to + "번 기둥으로 옮긴다.");
            Hanoi(n - 1, by, from, to);
        }
    }
    public static void main(String[] args) {
        Hanoi(3,1,2,3);
    }
}
