package Sort;

/**
 * Created by ksk on 2016-04-20.
 */
public class BubbleSort {

    static void Sort(int[] arry) {
        int temp;
        for (int i = 0; i < arry.length - 1; i++) {
            for (int j = 0; j < arry.length - 1 - i; j++) {
                if (arry[j] > arry[j + 1]) {
                    temp = arry[j + 1];
                    arry[j + 1] = arry[j];
                    arry[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {2, 4, 3, 1, 0, 5, 7, 6};

        Sort(test);

        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
}
