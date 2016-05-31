package InitNconstructorDemo;

/**
 * Created by ksk on 2016-03-24.
 */

class Calculator {
    int a, b;

    //기존의 직접 값을 세팅했던 방식은 코드의 복잡성을 증가시키고 실수로 세팅을 안 하여 생기는 오류를 유발할 수 있다.
    //이걸 개선한 것이 생성자
    /*public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }*/
    //생성자
    //값을 반환하지 않는다.
    //생성자의 이름은 클래스의 이름과 동일하다.
    //클래스 내부의 그 어떤 메소드보다도 먼저 실행되도록 약속되어 있다.
    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void sum() {
        System.out.println(this.a + this.b);
    }
}


public class InitNconstructor {
    public static void main(String[] args) {
        System.out.println("*************STEP1*************");
        Calculator cal1 = new Calculator(10, 20);
        //할 필요가 없다
        //cal1.setValue(10, 20);
        cal1.sum();
        System.out.println("*************STEP1 END*************");
    }
}
