package Math;

/**
 * Created by ksk on 2016-06-01.
 */
public class Fibonachi {
    private static int Fibo(int n) {
        int i, tmp, right = 1, left = 0;
        if (n < 2) {
            return n;
        }
        for (i = 2; i <= n; i++) {
            tmp = right;
            right += left;
            left = tmp;
        }
        return right;
    }

    private static void Fibo2(int n) {
        int i, tmp, right = 1, left = 0;

        for (i = 0; i < n; i++) {
            System.out.println(right);
            tmp = right;
            right += left;
            left = tmp;
        }
    }
    public static void main(String[] args) {

    }
}
