package Sort;

/**
 * Created by ksk on 2016-05-31.
 */
public class HeepSort {
    private static int heapSize = -1;

    private static void Sort(int[] array) {
        int[] heepArray = new int[array.length];

        //입력된 배열을 upHeep으로 heep배열에 정렬
        for (int key : array) {
            upHeep(heepArray, key);
        }

        //heep배열의 요소들을 downHeep하여 원래의 배열로 재정렬
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = downHeep(heepArray);
        }
    }

    private static void upHeep(int[] heepArray, int key) {
        //슈도코드
        //insert_max_heap(A, key)
        //  heap_size ← heap_size + 1;
        //  i ← heap_size;
        //  A[i] ← key;
        //  while (i ≠ 1 and A[i] > A[PARENT(i)]) do
        //      A[i] ↔ A[PARENT(i)];
        //      i ← PARENT(i);

        //PARENT(i) : (i/2)
        //LEFT(i) : (i * 2)
        //RIGHT(i) : (i * 2 + 1)
        heapSize = heapSize + 1;//새로운 요소가 들어가므로 사이즈 1 증감
        int i = heapSize;
        heepArray[i] = key;//heep배열의 마지막 위치에 새로운 요소 삽입

        while (i != 0 && heepArray[i] > heepArray[(i - 1) / 2]) {//삽입된 요소가 루트노드가 아니고 삽입된 요소의 부모노드보다 삽입된 요소가 더 클 경우 반복
            Swap(heepArray, i, (i - 1) / 2);//부모노드와 위치 변경
            i = (i - 1) / 2;//변경된 위치를 기준점으로 재설정
        }
    }

    private static int downHeep(int[] heepArray) {
        //슈도코드
        //delete_max_heap(A)
        //  item ← A[1];
        //  A[1] ← A[hsize];
        //  heap_size ← hsize - 1;
        //  i ← 1;
        //  while (LEFT(i) ≤ hsize) do
        //      if (RIGHT(i) > hsize or A[LEFT(i)] > A[RIGHT(i)]) then
        //          largest ← LEFT(i);
        //      else
        //          largest ← RIGHT(i);
        //      if A[i] > A[largest] then break;
        //      A[i] ↔ A[largest];
        //      i ← largest;
        //  return item;

        int largest;
        int item = heepArray[0];//heep배열의 첫번째 요소를 빼넴
        heepArray[0] = heepArray[heapSize];//마지막 요소를 첫번째 위치로 이동
        heapSize = heapSize - 1;//요소를 하나 뺏으므로 배열의 크기 1 가감
        int i = 0;
        while ((i * 2 + 1) <= heapSize) {//왼쪽 자식노드가 있으면 반복
            if ((i * 2 + 2) > heapSize || heepArray[i * 2 + 1] > heepArray[i * 2 + 2]) {//오른쪽 자식노드가 없거나 왼쪽 자식노드가 오른쪽 자식노드보다 클 경우 비교 대상으로 설정
                largest = i * 2 + 1;
            } else {
                largest = i * 2 + 2;
            }
            if (heepArray[i] > heepArray[largest]) {//현재의 노드가 비교 대상이 되는 자식노드보다 클 경우 루프를 멈춤
                break;
            }
            Swap(heepArray, i, largest);
            i = largest;//자리를 바꾼 자식노드의 위치를 기준 위치로 재설정
        }
        return item;//첫번째 아이템 반환
    }

    private static void Swap(int[] heepArray, int left, int right) {
        int temp;
        temp = heepArray[left];
        heepArray[left] = heepArray[right];
        heepArray[right] = temp;
    }

    public static void main(String[] args) {
        int[] test = {10, 8, 9, 1, 4, 3, 6, 2, 7, 5};

        Sort(test);

        for (int i : test) {
            System.out.println(i);
        }
    }
}
