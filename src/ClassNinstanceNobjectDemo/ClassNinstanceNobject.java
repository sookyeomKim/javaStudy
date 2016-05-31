package ClassNinstanceNobjectDemo;

/**
 * Created by ksk on 2016-03-24.
 */

//클래스-연관되어 있는 변수와 메소드의 집합
class Calculator {
    int a, b;

    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void sum() {
        System.out.println(this.a + this.b);
    }
}

public class ClassNinstanceNobject {

    //인스턴스 메소드 활용
    public void instanceSum(int a, int b) {
        System.out.println("instance=" + (a + b));
    }

    //스태틱 메소드 활용
    public static void staticSum(int a, int b) {
        System.out.println("static=" + (a + b));
    }

    public static void main(String[] args) {
        System.out.println("*************STEP1*************");
        // 아래의 로직이 1000줄 짜리의 복잡한 로직이라고 가정한다면 이것은 매우 비효율적인 코드다
        /*System.out.println(10 + 20);
        System.out.println(20 + 30);*/

        //이를 개선하기 위해 다음과 같이 메소드라는 개념을 쓴다.
        //인스턴스 메소드 활용

        ClassNinstanceNobject cio = new ClassNinstanceNobject();
        cio.instanceSum(10, 20);
        cio.instanceSum(20, 30);

        //정적 메소드 활용
        staticSum(10, 20);
        staticSum(20, 30);
        System.out.println("*************STEP1 END*************");


        System.out.println("*************STEP2*************");
        //계산기를 예로 들었을 때 값으로 상징되는 변수와 연산자로 상징되는 메소드를 서로 연관되어 있는 것끼리 그룹핑할 것이냐라는 고민에서 나온 것이 '객체'
        //정리하자면 특정 기능에 대한 상태(변수)와 행위(메소드)를 변수와 메소드로 구현하여 그룹핑한 것이 '객체'
        //이러한 객체를 이용한 프로그래밍이 객체지향 프로그래밍
        int a, b;

        a = 10;
        b = 20;
        staticSum(a, b);

        a = 20;
        b = 30;
        staticSum(a, b);
        //위의 코드의 문제점
        //1. 협업을 할 때 다른 개발자가 변수 a와b를 다르게 해석하여 다른 값을 넣게 되고 결국 다른 값을 반환하게 된다.
        //2. 첫 번째 sum메소드와 두 번째 sum메소드는 같은 메커니즘을 같고 있다. 이것은 코드의 중복을 야기한다.
        //3. 기능을 재사용할 수 없다.
        //이런 문제점을 해결하고자 객체지향 프로그래밍을 이용한다.
        System.out.println("*************STEP2 END*************");


        System.out.println("*************STEP3*************");

        Calculator cal1 = new Calculator();//객체(클래스의 분신)
        //클래스가 설계도라면 cal1은 설계도(클래스)로 만든 제품(인스턴스)를 담은 것이다.
        //이때 cal1의 데이터 타입을 해당 인스턴스의 클래스로 한다.
        cal1.setValue(10, 20);
        cal1.sum();

        Calculator cal2 = new Calculator();
        cal2.setValue(20, 30);
        cal2.sum();

        //클래스는 단순히 변수와 메소드의 묶음이 아니라 재활용성을 높이기 위해서다
        //정리-하나의 클래스를 바탕으로 서로 다른 상태를 가진 인스턴스를 만들어 각기 다른 행동을 취하는 객체를 여러개 만들 수 있다.
        System.out.println("*************STEP3 END*************");
    }
}
