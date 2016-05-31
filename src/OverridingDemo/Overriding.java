package OverridingDemo;

/**
 * Created by ksk on 2016-03-24.
 */
class Calculator {
    int left, right;

    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void sum() {
        System.out.println(this.left + this.right);
    }

    public int avg() {
        return (this.left + this.right) / 2;
    }
}

class SubstractionableCalculator extends Calculator {

    public void sum() {
        System.out.println("실행 결과는 " + (this.left + this.right) + "입니다.");
    }

    public int avg() {
        //상위 클래스와 중복이 일어난다.
        //return (this.left + this.right)/2;
        //상위 클래스에서 계산된 값을 불러온다.
        return super.avg();
        //여기에 추가적으로 코드를 작성하여 기능을 추가할 수 있다.
    }

    public void substract() {
        System.out.println(this.left - this.right);
    }
}

class A {
    protected void test() {
        System.out.println("성공");
    }
}

//A의 test가 자기 자신을 반환하고 B에서 재정의한 test는 부모의 test를 반환하면 무한루프발생(stackoverflow에러)
class B extends A {
    @Override
    public void test() {
        super.test();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Overriding {
    public static void main(String[] args) {
        System.out.println("*************STEP1*************");
        //오버라이딩의 조건
        //1.메소드의 이름이 같아야 한다.
        //2.메소드의 매개변수의 개수와 데이터 타입 그리고 순서가 같아야 한다.
        //3.메소드의 리턴 타입이 같아야 한다.
        //재정의할 때 접근제어자는 재정의할 메소드의 접근제어자보다 더 포괄적이거나 같아야한다.
        //당연히 private 메소드는 재정의가 안 되는 메소드라는걸 알아두자
        SubstractionableCalculator c1 = new SubstractionableCalculator();
        c1.setOprands(10, 20);
        c1.sum();
        c1.avg();
        c1.substract();
        System.out.println("*************STEP1 END*************");


        System.out.println("*************STEP2*************");
        B b1 = new B();
        b1.test();
        System.out.println("*************STEP2 END*************");
    }
}
