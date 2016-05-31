package Sort;

/**
 * Created by ksk on 2016-05-24.
 */
public class QuickSort {

    private static void Sort(int[] array) {
        QuickSort(array, 0, array.length - 1);
    }

    private static void QuickSort(int[] array, int start, int end) {
        int i = start;                          // 왼쪽에서 시작하여 오른쪽으로 피봇보다값이 큰 값을 찾기 위한 인덱스입니다.
        int k = end;                            // 오른쪽에서 시작하여 왼쪽으로 피봇보다값이 작은 값을 찾기 위한 인덱스입니다.

        if (end - start >= 1) {             // 정렬의 추가 실행여부 확인(마지막과 시작의 인덱스가 같다는 것은 모든 정렬을 마치고 왔다는 의미이므로 바로 메소드를 벗어납니다)
            int pivot = array[start];       // 배열의 맨 좌측을 피봇으로 설정합니다.

            while (k > i) {                 // i와 k가 엇갈리기 전까지 피봇을 기준으로 비교하여 Swap합니다.
                while (array[i] <= pivot && i <= end && k > i) {// 피봇의 값보다 큰 요소의 위치를 찾아 냅니다.
                    i++;
                }
                while (array[k] > pivot && k >= start && k >= i) {// 피봇의 값보다 작은 요소의 위치를 찾아 냅니다.
                    k--;
                }
                if (k > i) {// 엇갈리기 전까지 피봇보다 값이 큰 요소와 작은 요소를 서로 Swap합니다.
                    Swap(array, i, k);
                }
            }
            Swap(array, start, k);          // 엇갈렸다면 피봇과 엇갈린 다음의 k(오른쪽에서 시작한 인덱스)와 Swap하여 기준점으로 삼습니다. 혹은 피봇이 최대값일 경우 맨 뒤의 요소와 Swap하여 정렬을 수행하도록 합니다.

            QuickSort(array, start, k - 1); // 기준점의 왼쪽 partition을 재정렬합니다.
            QuickSort(array, k + 1, end);   // 기준점의 오른쪽 partition을 재정렬합니다.
        }
    }

    private static void Swap(int[] array, int left, int right) {//왼쪽값과 오른쪽값을 Swap하는 메소드
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        int[] test = {2, 4, 3, 1, 0, 5, 7, 6};

        Sort(test);

        for (int val : test) {
            System.out.println(val);
        }
    }
}
