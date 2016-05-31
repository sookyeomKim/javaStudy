package OverloadingDemo;

/**
 * Created by ksk on 2016-03-25.
 */

class Calculator {
    //예제를 위한 방도일 뿐 아래처럼 계산기능을 위해 입력값의 갯수에 따라 정적으로 만드는 것은 매우 비효율적이다
    //이럴땐 배열을 이용하자
    int left, right;
    int third = 0;

    public void setOprands(int left, int right) {
        System.out.println("setOprands(int left, int right)");
        this.left = left;
        this.right = right;
    }

    public void setOprands(int left, int right, int third) {
        System.out.println("setOprands(int left, int right, int third)");
        //해당 클래스의 메소드를 불러온다.
        this.setOprands(left, right);
        this.third = third;
    }

    public int setOprands(String third) {
        return Integer.parseInt(third);
    }

    void a(int a) {
        System.out.println("test");
    }

    int a() {
        return 1;
    }

    public void sum() {
        System.out.println(this.left + this.right + this.third);
    }

    public void avg() {
        System.out.println((this.left + this.right + this.third) / 3);
    }
}

public class Overloading {
    public static void main(String[] args) {
        System.out.println("*************STEP1*************");
        //오버로딩이란-동일 이름으로 다양한 매개변수를 갖는 메소드를 만드는 것을 말함
        Calculator c1 = new Calculator();
        c1.setOprands(10, 20);
        c1.sum();
        c1.avg();
        c1.setOprands(10, 20, 30);
        c1.sum();
        c1.avg();
        System.out.println(c1.setOprands("4"));
        System.out.println("*************STEP1 END*************");
    }
}
