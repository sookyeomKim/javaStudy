package PolymorphismDemo;

/**
 * Created by ksk on 2016-03-26.
 */

class A {
    public String x() {
        return "A.x";
    }
}

class B extends A {
    public String x() {
        return "B.x";
    }

    public String y() {
        return "y";
    }
}

class B2 extends A {
    public String x() {
        return "B2.x";
    }
}



abstract class Calculator{
    int left, right;
    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    }
    int _sum() {
        return this.left + this.right;
    }
    public abstract void sum();
    public abstract void avg();
    public void run(){
        sum();
        avg();
    }
}
class CalculatorDecoPlus extends Calculator {
    public void sum(){
        System.out.println("+ sum :"+_sum());
    }
    public void avg(){
        System.out.println("+ avg :"+(this.left+this.right)/2);
    }
}
class CalculatorDecoMinus extends Calculator {
    public void sum(){
        System.out.println("- sum :"+_sum());
    }
    public void avg(){
        System.out.println("- avg :"+(this.left+this.right)/2);
    }
}



interface I2{
    public String A();
}
interface I3{
    public String B();
}
class D implements I2, I3{
    public String A(){
        return "A";
    }
    public String B(){
        return "B";
    }
}

public class PolymorphismDemo {
    public static void execute(Calculator cal){
        System.out.println("실행결과");
        cal.run();
    }

    public static void main(String[] args) {
        System.out.println("*************STEP1*************");
        //인스턴스화한 클래스는 데이터타입을 상위클래스로 할 수도 있다.
        //이러한 방식은 하위 클래스마다 다르게 오버라이딩한 메소드들을 입맛에 따라 사용하기 위해 사용되는 클래스의 다형성을 이용한 것이다.
        A obj = new B();
        A obj2 = new B2();
        //obj.y();
        System.out.println(obj.x());
        System.out.println(obj2.x());
        System.out.println("*************STEP1 END*************");



        System.out.println("*************STEP2*************");
        Calculator c1 = new CalculatorDecoPlus();
        c1.setOprands(10, 20);
        c1.run();

        Calculator c2 = new CalculatorDecoMinus();
        c2.setOprands(10, 20);
        c2.run();

        //클래스의 다형성을 이용하는 이유는 밑의 로직에 있다.
        //만약 덧셈과 뺄셈에 대한 인스턴스의 데이터타입이 상위클래스가 아니고 각 자신이었다면 위의 execute메소드를 두 종류를 만들었어야 됐을 것이다.
        //이것은 코드의 중복을 초래한다.
        execute(c1);
        execute(c2);
        System.out.println("*************STEP2 END*************");



        System.out.println("*************STEP3*************");
        D obj1 = new D();
        I2 objI2 = new D();
        I3 objI3 = new D();

        obj1.A();
        obj1.B();

        objI2.A();
        //objI2.B();

        //objI3.A();
        objI3.B();
        //특정 인터페이스의 기능만을 사용하고 싶을 때 위와 같은 방법을 사용한다.
        //다형성이란
        //같은 방식으로 요청하지만 서로 다른 결과물을 반환하는 것이 다형성

        //이러한 노력들은 결국 코딩을 좀더 의미론적으로 코딩하여 각 기능에 대한 로직 분석을 쉽게 하기 위함이고 이것이 바로 객체지향프로그래밍의 장점이다.
        System.out.println("*************STEP3 END*************");
    }
}
