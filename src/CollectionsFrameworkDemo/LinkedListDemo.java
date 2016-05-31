package CollectionsFrameworkDemo;

/**
 * Created by ksk on 2016-04-12.
 */

class MyLinkedList {
    //첫번째 노드를 가리키는 필드
    private Node head;
    //마지막 노드를 가리키는 필드
    private Node tail;
    //리스트의 크기
    private int size = 0;

    //노드 객체를 구현
    private class Node {
        //데이터가 저장될 필드
        private Object data;
        //다음 노드를 가리키는 필드
        private Node next;

        public Node(Object input) {
            this.data = input;
            this.next = null;
        }

        //노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public void addFirst(Object input) {
        //노드를 생성합니다.
        Node newNode = new Node(input);
        //새로운 노드의 다음 노드로 헤드를 지정합니다.
        newNode.next = head;
        //헤드로 새로운 노드를 지정합니다.
        head = newNode;
        size++;
        //만약 헤드의 다음 노드가 null이면 헤드를 테일로 지정(노드가 하나일 때)
        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(Object input) {
        Node newNode = new Node(input);
        //데이터가 없는 상태면 앞뒤 어디에 넣어도 상관없기 때문에 addFirst재활용
        if (size == 0) {
            addFirst(input);
        } else {//그게 아니라면
            //마지막 노드의 다음 노드로 생성한 노드를 지정합니다.
            tail.next = newNode;
            //마지막 노드를 갱신합니다.
            tail = newNode;
            //노드 개수를 1 증가 시킵니다.
            size++;
        }
    }

    Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public void add(int k, Object input) {
        //k가 0이라면 addFirst 재활용
        if (k == 0) {
            addFirst(input);
        } else {
            //첫 번째 노드를 temp1로
            Node temp1 = node(k - 1);
            //첫 번째 노드의 다음 노드를 temp2로
            Node temp2 = temp1.next;
            //노드 생성
            Node newNode = new Node(input);
            //첫 번째 노드의 다음 노드에 새로운 노드로 지정
            temp1.next = newNode;
            //새로운 노드의 다음 노드로 첫 번째 노드의 다음 노드를 지정
            newNode.next = temp2;
            //크기 1 증가
            size++;
            //만약 새로운 노드의 다음 노드가 null일 경우 새로운 노드를 tail로 지정
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    public Object removeFirst() {
        //현재 헤드를 temp에 저장하고 현재 헤드의 다음 노드를 현재 헤드로 바꾼다. 없으면 null이 들어간다
        Node temp = head;
        head = head.next;
        //데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담습니다.
        Object returnData = temp.data;

        //temp를 없앤다.
        temp = null;
        size--;
        return returnData;
    }

    public Object remove(int k) {
        if (k == 0) {
            return removeFirst();
        } else {
            //k-1번째 노드를 temp의 값으로 지정합니다.
            Node temp = node(k - 1);
            //삭제할 노드를 todoDeleted에 기록
            //지금 바로 제거하면 삭제할 노드 두의 노드를 연결할 수 없습니다.
            Node todoDeleted = temp.next;
            //삭제 앞의 노드의 다음 노드로 삭제 뒤 노드를 지정
            temp.next = temp.next.next;
            //삭제된 데이터를 리턴 받기위해 저장
            Object returnData = todoDeleted.data;
            if (todoDeleted == tail) {
                tail = temp;
            }
            todoDeleted = null;
            size--;
            return returnData;
        }
    }

    public Object removeLast() {
        return remove(size - 1);
    }

    public int size() {
        return size;
    }

    public Object get(int k) {
        Node temp = node(k);
        return temp;
    }

    public int indexOf(Object data) {
        //탐색 대상이 되는 노드를 temp로 지정(시작은 헤드)
        Node temp = head;
        int index = 0;
        //탐색 값과 탐색 대상의 값을 비교합니다.
        while (temp.data != data) {
            temp = temp.next;
            index++;
            //temp의 값이 null이라는 것은 더 이상 탐색 대상이 없다는 것
            if (temp == null) {
                return -1;
            }
        }
        return index;
    }

    // 반복자를 생성해서 리턴해줍니다.
    public ListIterator listIterator() {
        return new ListIterator();
    }

    public class ListIterator {
        private Node lastReturned;
        private Node next;
        private int nextIndex;

        ListIterator() {
            //무조건 처음은 헤드
            next = head;
        }

        public Object next() {
            //헤드가 담긴 next를 첫번째 반환으로 하고
            lastReturned = next;
            //next의 다음 노드를 next로 한다(반복)
            next = next.next;
            //next의 진행상황을 위해
            nextIndex++;
            return lastReturned.data;
        }

        public boolean hasNext() {
            return nextIndex < size();
        }

        public void add(Object input) {
            Node newNode = new Node(input);

            if (lastReturned == null) {
                head = newNode;
                newNode.next = next;
            } else {
                lastReturned.next = newNode;
                newNode.next = next;
            }

            lastReturned = newNode;
            nextIndex++;
            size++;
        }

        public void remove() {
            if (nextIndex == 0) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(nextIndex - 1);
            nextIndex--;
        }
    }

    public String toString() {
        //노드가 없다면 []를 리턴합니다.
        if (head == null) {
            return "[]";
        }

        //탐색을 시작합니다.
        Node temp = head;
        String str = "[";
        //다음 노드가 없을 때까지 반복문을 실행합니다.
        //마지막 노드는 다음 노드가 없기 때문에 아래의 구문은 마지막 노드는 제외됩니다.
        while (temp.next != null) {
            str += temp.data + ",";
            temp = temp.next;
        }

        //while문에서 빠진 마지막 노드를 포함시킵니다.
        str += temp.data;
        return str + "]";
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        MyLinkedList numbers = new MyLinkedList();
        numbers.addFirst(10);
        numbers.addFirst(15);
        numbers.addFirst(20);
        numbers.addFirst(30);
        /*MyLinkedList.ListIterator i = numbers.listIterator();

        while (i.hasNext()) {
            if ((int) i.next() == 15) {
                //이 방법으로 하면 remove로 다시 한번 for을 돌아 노드를 찾기 때문에 비효율적이다.
                //이 문제를 해결하기 위해 prev가 필요하고 양방향 LinkedList가 필요하다
                i.remove();
            }
        }*/
        System.out.println(numbers);
    }
}