package Graph;

import java.util.LinkedList;

/**
 * Created by ksk on 2016-05-31.
 */
public class teset {
    public static void main(String[] args) {
        LinkedList<Integer> S = new LinkedList<>();
        LinkedList<Integer> Q = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            Q.addLast(i);
        }

        S.addLast(1);

        for (Object e : Q) {
            System.out.println(S.contains(e));
        }

        System.out.println(Integer.MAX_VALUE+1);
    }
}
