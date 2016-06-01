package Math;

/**
 * Created by ksk on 2016-06-01.
 */
public class Power {
    private static int Power(int v, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * v;
        }
        return result;
    }

    private static int Power2(int v, int n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            return Power2(v * v, n / 2);
        } else {
            return v * Power2(v * v, (n - 1) / 2);
        }
    }
    public static void main(String[] args) {

    }
}
