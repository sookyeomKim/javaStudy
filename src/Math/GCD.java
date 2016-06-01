package Math;

/**
 * Created by ksk on 2016-06-01.
 */
public class GCD {
    private static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        if (a == 0) {
            return b;
        }
        return GCD(b, a % b);
    }

    public static void main(String[] args) {

    }
}
