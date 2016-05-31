package ReferenceDemo;

/**
 * Created by ksk on 2016-03-27.
 */
class A {
    public int id;

    A(int id) {
        this.id = id;

    }
}

public class ReferenceDemo {
    public static void runValue() {
        int a = 1;
        int b = a;
        b = 2;
        System.out.println("runValue, " + a);
    }

    public static void runReference() {
        A a = new A(1);
        A b = a;
        b.id = 2;
        System.out.println("runReference, " + a.id);
    }

    public static void main(String[] args) {
        //new 생성하는 데이터 타입은 참조자료형이다.
        System.out.println("*************STEP1*************");
        runValue();
        runReference();//javascript의 객체의 참조 특성과 비슷
        System.out.println("*************STEP1 END*************");
    }
}
