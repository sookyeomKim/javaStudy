package Math;

/**
 * Created by ksk on 2016-06-01.
 */
public class FindMax {
    public static int Find_Max(int[] list, int length) {
        int tmp = list[0];
        for (int i = 0; i < length; i++) {
            if (tmp < list[i]) {
                tmp = list[i];
            }
        }
        return tmp;
    }

    public static void main(String[] args) {

    }
}
