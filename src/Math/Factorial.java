package Math;

/**
 * Created by ksk on 2016-06-01.
 */
public class Factorial {
    private static int Factoral(int a) {
        if (a < 1) {
            return 1;
        }
        return a * Factoral(a - 1);
    }
    public static void main(String[] args) {

    }
}
