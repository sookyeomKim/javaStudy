package Search;

/**
 * Created by ksk on 2016-06-04.
 */
public class BinarySearch {
    static void Search(int[] array, int number, int min, int max) {
        int mid = (int) Math.floor((min + max) / 2);

        if (array[mid] == number) {
            System.out.println(mid + "에 있다.");
        } else if (array[mid] > number) {
            Search(array, number, min, mid - 1);
        } else if (array[mid] < number) {
            Search(array, number, mid + 1, max);
        }
    }

    public static void main(String[] args) {
        int[] test = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Search(test, 0, 0, test.length);
    }
}
