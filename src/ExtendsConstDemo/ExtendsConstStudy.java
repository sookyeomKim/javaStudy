package ExtendsConstDemo;

/**
 * Created by ksk on 2016-03-24.
 */

class Calculator {
    int left = 20;
    int right = 40;

    //기본 생성자를 명시해주면 하위 클래스의 생성자가 기본 생성자를 호출할 수 있기 때문에 에러가 발생하지 않는다.
    //그러나 현재 이 방법은 하위 클래스의 생성자와 상위 클래스의 생성자가 중복을 띄고 있기때문에 리팩토링이 필요하다.
    public Calculator() {
    }

    public Calculator(int left, int right) {
        this.left = left;
        this.right = right;
    }

    /*public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }*/

    public void sum() {
        System.out.println(this.left + this.right);
    }

    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}

class SubstractionableCalculator extends Calculator {
    //상위클래스에 메개변수를 받는 생성자를 명시해주면 하위클래스의 생성자는 실행되기전에 상위클래스의 기본 생성자를 호출한다는 약속이 되어있다.
    /*public SubstractionableCalculator(int left, int right) {
        this.left = left;
        this.right = right;
    }*/

    //위의 중복 문제를 해결한 것이 super이다.
    //super는 상위 클래스를 의미한다.
    //super()는 상위 클래스의 생성자를 의미한다. 즉, 상위 클래스의 생성자를 불러온다는 것
    //이렇게해서 코드의 중복을 줄일 수 있다.
    //또한, 상위클래스에서 기본 생성자를 안 만들어주어도 된다.
    public SubstractionableCalculator(int left, int right) {
        super(left, right);
    }

    public void substract() {
        System.out.println(this.left - this.right);
    }
}

public class ExtendsConstStudy {
    //이렇게 기본 생성자를 명시적으로 만들어주면 밑의 코드의 에러는 없어진다.
    public ExtendsConstStudy() {
    }

    public ExtendsConstStudy(int param1) {
    }

    public static void main(String[] args) {
        System.out.println("*************STEP1*************");
        //java는 매게변수가 없는 빈 메소드의 기본 생성자를 자동으로 만든다.
        //그러나 매게변수를 갖는 생성자를 명시적으로 만들어주면 기본 생성자가 만들어지 않아 밑의 코드는 에러를 발생시킨다.
        ExtendsConstStudy c = new ExtendsConstStudy();
        System.out.println("*************STEP1 END*************");


        System.out.println("*************STEP2*************");
        SubstractionableCalculator c1 = new SubstractionableCalculator(10, 20);
        c1.sum();
        c1.avg();
        c1.substract();
        Calculator c2 = new Calculator(50, 100);
        c2.sum();
        c2.avg();
        System.out.println("*************STEP2 END*************");
    }
}
