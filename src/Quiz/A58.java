package Quiz;

import java.util.*;

/**
 * Created by ksk on 2016-04-10.
 */
public class A58 {
    public static Iterator reverse(List list) {
        Collections.reverse(list);
        return list.iterator();
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        //개선 for문의 : 우측에는 배열이나 Iterable 를 상속받은 클래스의 변수만 올 수 있음
        //밑의 reverse는 iterator를 반환 중인데 iterator는 Iterable를 상속하고 있지 않기 때문에 쓸 수 없다.
        /*for (Objects obj :reverse(list)) {
            System.out.print(obj + ", ");
        }*/

        for (Object obj:list){
            System.out.print(obj+", ");
        }
    }
}
