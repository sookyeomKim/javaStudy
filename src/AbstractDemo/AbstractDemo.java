package AbstractDemo;

/**
 * Created by ksk on 2016-03-26.
 */

abstract class A {
    abstract void test();
}

class B extends A {
    @Override
    void test() {
        System.out.println();
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
        System.out.println("*************STEP1*************");
        //abstract는 실제 구현에 대한 책임을 상속한 클래스에게 일임,강제하는 것
        //이런 특성에 의해 abstract를 이용한 개발방법론을 템플릿 메소드 패턴이라고 한다.
        //"나에게는 구현되지 않은 메소드와 구현된 메소드가 있다. 나를 상속받아 사용하고 싶으면 나의 구현되지 않은 메소드를 꼭 오버라이딩하고 이외의 구현된 메소드들은 너의 입맛에 맞게 사용하거나 하지 말아라
        //특정 기능에 대해 사용자가 커스터마이징할 수 있도록 하는 것

        //디자인패턴의 장점
        //1.좋은 설계를 단기간에 학습할 수 있다
        //2. 커뮤니케이션에 도움이 된다.
        System.out.println("*************STEP1 END*************");
    }
}
