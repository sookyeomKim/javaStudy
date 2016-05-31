package Sort;

/**
 * Created by ksk on 2016-05-23.
 */
public class InsertionSort {
    static void Sort(int[] arry) {
        for (int index = 1; index < arry.length; index++) {

            int temp = arry[index];
            int aux = index - 1;

            while ((aux >= 0) && (arry[aux] > temp)) {
                arry[aux + 1] = arry[aux];
                aux--;
            }
            arry[aux + 1] = temp;
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
