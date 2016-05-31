package ExtendsDemo;

/**
 * Created by ksk on 2016-03-24.
 */

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

class SubstractionableCalculator extends Calculator {
    public void substract() {
        System.out.println(this.a - this.b);
    }
}

class DivisionableCalculator extends SubstractionableCalculator {
    public void division() {
        System.out.println(this.a / this.b);
    }
}

public class ExtendsStudy {
    public static void main(String[] args) {
        System.out.println("*************STEP1*************");
        //상속을 쓰는 이유
        //1.객체를 자신이 만들지 않았기 때문에 상대방이 소스 업데이트를 했을 때 나의 코드가 사라질 수가 있다.
        //2.객체가 다양한 곳에서 활용되고 있는데 메소드를 추가하면 다른 곳에서는 불필요한 기능이 포함될 수 있다.
        //이것은 자연스럽게 객체를 사용하는 입장에서 몰라도 되는 것까지 알아야 하는 문제가 된다.

        SubstractionableCalculator cal = new SubstractionableCalculator();
        cal.setValue(10, 20);
        cal.substract();

        DivisionableCalculator cal2 = new DivisionableCalculator();
        cal2.setValue(40, 20);
        cal2.division();
        System.out.println("*************STEP1 END*************");
    }
}
