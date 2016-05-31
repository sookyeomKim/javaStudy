package CollectionsFrameworkDemo;

import java.util.*;

/**
 * Created by ksk on 2016-03-27.
 */
public class CollectionsFrameworkDemo {
    static void iteratorUsingForEach(HashMap map) {
        //Map.Entry에 getKey와 getValue가 들어있다.
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    static void iteratorUsingIterator(HashMap map) {
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> i = entries.iterator();
        while (i.hasNext()) {
            Map.Entry<String, Integer> entry = i.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        //컬렉션을 사용할 때는 데이터 타입은 가급적 해당 컬렉션을 대표하는 인터페이스를 사용하는 것이 좋다.
        System.out.println("*************STEP1*************");
        String[] arrayObj = new String[2];
        arrayObj[0] = "one";
        arrayObj[1] = "two";
        // arrayObj[2] = "three"; 오류가 발생한다.
        for (int i = 0; i < arrayObj.length; i++) {
            System.out.println(arrayObj[i]);
        }

        /*ArrayList al = new ArrayList();
        al.add("one");
        al.add("two");
        al.add("three");
        for(int i=0; i<al.size(); i++){
            String value = (String)al.get(i);
            System.out.println(value);
        }*/

        //제네릭을 이용하면 형변환을 할 필요가 없다.
        ArrayList<String> al = new ArrayList<String>();
        al.add("one");
        al.add("two");
        al.add("three");
        for (int i = 0; i < al.size(); i++) {
            String value = al.get(i);
            System.out.println(value);
        }
        System.out.println("*************STEP1 END*************");


        System.out.println("*************STEP2*************");
        //List와 Set의 큰 차이점
        //List는 중복을 허용하고 Set은 중복을 허용하지 않는다.
        HashSet<Integer> A = new HashSet<Integer>();
        A.add(1);
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);

        //hi라는 복사본을 만들어 사용한다.
        Iterator hi = (Iterator) A.iterator();
        while (hi.hasNext()) {
            System.out.println(hi.next());
        }
        System.out.println("*************STEP2 END*************");


        System.out.println("*************STEP3*************");
        HashSet<Integer> B = new HashSet<Integer>();
        B.add(1);
        B.add(1);
        B.add(2);

        HashSet<Integer> C = new HashSet<Integer>();
        C.add(1);
        C.add(1);
        C.add(2);

        //B에 대해서 C는 부분집합인가?
        System.out.println(B.containsAll(C));

        // A에 B를 합친다.
        A.addAll(B);

        //A와 B의 교집합
        A.retainAll(B);

        //A에 B를 뺀 차집합
        A.removeAll(B);
        System.out.println("*************STEP3 END*************");


        System.out.println("*************STEP4*************");
        //Map
        //key는 중복이 안 되고 value는 중복이 된다.
        HashMap<String, Integer> a = new HashMap<String, Integer>();
        a.put("one", 1);
        a.put("two", 2);
        a.put("three", 3);
        iteratorUsingForEach(a);
        iteratorUsingIterator(a);
        System.out.println("*************STEP4 END*************");


        System.out.println("*************STEP5*************");
        //소팅은 List만 되고 소팅을 만들기 위해선
        //Comparable을 반드시 구현한 클래스여야 한다.
        //a-b는 오름차순
        //b-s는 내림차순
        List<Computer> computers = new ArrayList<Computer>();
        computers.add(new Computer(500, "egoing"));
        computers.add(new Computer(200, "leezche"));
        computers.add(new Computer(3233, "graphittie"));
        Iterator i = computers.iterator();
        System.out.println("before");
        while (i.hasNext()) {
            System.out.println(i.next().hashCode());
        }
        Collections.sort(computers);
        System.out.println("\nafter");
        i = computers.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("*************STEP5 END*************");
    }
}

class Computer implements Comparable {
    int serial;
    String owner;

    Computer(int serial, String owner) {
        this.serial = serial;
        this.owner = owner;
    }

    //Comparable의 메소드드
    public int compareTo(Object o) {
        return this.serial - ((Computer) o).serial;
    }

    public String toString() {
        return serial + " " + owner;
    }
}

