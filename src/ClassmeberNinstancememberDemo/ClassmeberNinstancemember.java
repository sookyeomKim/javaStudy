package ClassmeberNinstancememberDemo;

/**
 * Created by ksk on 2016-03-24.
 */
class Calculator {
    static double PI = 3.14;
    int left, right;

    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void sum() {
        System.out.println(this.left + this.right);
    }

    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}

class Calculator3 {

    public static void sum(int left, int right) {
        System.out.println(left + right);
    }

    public static void avg(int left, int right) {
        System.out.println((left + right) / 2);
    }
}

class C1 {
    static int static_variable = 1;
    int instance_variable = 2;

    static void static_static() {
        System.out.println(static_variable);
    }

    static void static_instance() {
        // 클래스 메소드에서는 인스턴스 변수에 접근 할 수 없다.
        //System.out.println(instance_variable);
    }

    void instance_static() {
        // 인스턴스 메소드에서는 클래스 변수에 접근 할 수 있다.
        System.out.println(static_variable);
    }

    void instance_instance() {
        System.out.println(instance_variable);
    }
}

public class ClassmeberNinstancemember {
    public static void main(String[] args) {
        System.out.println("*************STEP1*************");
        //인스턴스의 변수 - 인스턴스 마다 다른 값을 가질 수 있다.

        //클래스의 변수(스태틱) - 모든 인스턴스에서 똑같은 값을 갖는다.
        //클래스 변수의 용도
        //1.인스턴스에 따라서 변하지 않는 값이 필요한 경우
        //2.인스턴스를 생성할 필요가 없는 값을 클래스에 저장하고 싶은 경우
        //3.값의 변경 사항을 모든 인스턴스가 공유해야 하는 경우우
        Calculator c1 = new Calculator();
        System.out.println(c1.PI);

        Calculator c2 = new Calculator();
        System.out.println(c2.PI);

        System.out.println(Calculator.PI);

        c2.PI = 3;
        System.out.println(c2.PI);

        Calculator.PI = 4;
        System.out.println(Calculator.PI);
        System.out.println("*************STEP1 END*************");


        System.out.println("*************STEP2*************");
        //인스턴스 변수를 사용하지 않는 메소드는 스태틱을 지정하여 불필요한 메모리 낭비를 줄이자
        //단순 계산이나 1회성의 목적을 가지고 있는 메소드는 클래스 메소드(스태틱)로 사용하자
        Calculator3.sum(10, 20);
        Calculator3.avg(10, 20);

        Calculator3.sum(20, 40);
        Calculator3.avg(20, 40);
        System.out.println("*************STEP2 END*************");


        System.out.println("*************STEP3*************");
        C1 c = new C1();
        // 인스턴스를 이용해서 정적 메소드에 접근 -> 성공
        // 인스턴스 메소드가 정적 변수에 접근 -> 성공
        c.static_static();
        // 인스턴스를 이용해서 정적 메소드에 접근 -> 성공
        // 정적 메소드가 인스턴스 변수에 접근 -> 실패
        c.static_instance();
        // 인스턴스를 이용해서 인스턴스 메소드에 접근 -> 성공
        // 인스턴스 메소드가 클래스 변수에 접근 -> 성공
        c.instance_static();
        // 인스턴스를 이용해서 인스턴스 메소드에 접근 -> 성공
        // 인스턴스 메소드가 인스턴스 변수에 접근 -> 성공
        c.instance_instance();
        // 클래스를 이용해서 클래스 메소드에 접근 -> 성공
        // 클래스 메소드가 클래스 변수에 접근 -> 성공
        C1.static_static();
        // 클래스를 이용해서 클래스 메소드에 접근 -> 성공
        // 클래스 메소드가 인스턴스 변수에 접근 -> 실패
        C1.static_instance();
        // 클래스를 이용해서 인스턴스 메소드에 접근 -> 실패
        //C1.instance_static();
        // 클래스를 이용해서 인스턴스 메소드에 접근 -> 실패
        //C1.instance_instance();

        //인스턴스 메소드는 클래스 멤버에 접근할 수 있다(인스터스 메소드 안에 클래스 메소드,변수를 사용할 수 있다).
        //클래스 메소드는 인스턴스 멤버에 접근할 수 없다(클래스 메소드 안에 인스턴스 메소드,변수를 사용할 수 없다).
        //클래스를 통해 인스턴스 메소드에 직접 접근하려하면 클래스 입장에서 어떤 인스턴스에 접근해야할지를 몰라 에러를 발생시킴
        System.out.println("*************STEP3 END*************");
    }
}
