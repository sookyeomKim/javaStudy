package ExceptionDemo;

/**
 * Created by ksk on 2016-03-27.
 */

class Calculator {
    int left, right;

    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void divide() {
        try {
            System.out.println("계산결과는 ");
            System.out.println(this.left / this.right);
            System.out.println(" 입니다.");
        } catch (Exception e) {
            System.out.println("\n\ne.getMessage()\n" + e.getMessage());
            /*System.out.println("\n\ne.toString()\n" + e.toString());
            System.out.println("\n\ne.printStackTrace()");
            e.printStackTrace();*/
        }finally {//예외에 상관없이 무조건 실행되는 부분(작업의 뒷정리)
            System.out.println("파이널리");
        }
    }
}

public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("*************STEP1*************");
        Calculator c1 = new Calculator();
        c1.setOprands(10, 0);
        c1.divide();

        Calculator c2 = new Calculator();
        c2.setOprands(10, 5);
        c2.divide();
        System.out.println("*************STEP1 END*************");
    }
}
