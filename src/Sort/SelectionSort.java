package Sort;

/**
 * Created by ksk on 2016-05-17.
 */
public class SelectionSort {
    static void Sort(int[] arry) {
        int criterionIndex;
        int tmp;
        for (int i = 0; i < arry.length - 1; i++) {
            criterionIndex = i;
            for (int j = i + 1; j < arry.length; j++) {
                if (arry[j] < arry[criterionIndex]) {
                    criterionIndex = j;
                }
            }
            tmp = arry[i];
            arry[i] = arry[criterionIndex];
            arry[criterionIndex] = tmp;
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
