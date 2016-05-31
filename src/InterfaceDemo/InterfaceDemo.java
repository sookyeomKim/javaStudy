package InterfaceDemo;

/**
 * Created by ksk on 2016-03-26.
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        System.out.println("*************STEP1*************");
        //개발 기간을 단축하기 위해 여러 개발자와 파트를 나눠 개발을 진행하게 되었다.
        //그런데 각자 완성을 다 하고 이것을 합치려는데 파트마다 변수명이나 매개변수 숫자가 맞지 않아 합쳐지지 않았다
        //이러한 문제를 해결하기 위해 인터페이스를 사용한다.
        //인터페이스는 인터페이스에서 선언된 필드와 메소드를 무조건 구현하도록 하는 규제로써 일종의 클래스의 필드, 메소드 구성에 대한 명세서라고 보면 된다.

        //인터페이스의 규칙
        //1.하나의 클래스가 여러개의 인터페이스를 구현할 수 있다.
        //2.인터페이스끼리 상속이 된다.
        //3.맴버는 반드시 public이다

        //인터페이스는 information hiding이 목적이고
        //추상클래스는 polymorphism이 목적입니다.
        System.out.println("*************STEP1 END*************");
    }
}
