package ExceptionDemo3;

/**
 * Created by ksk on 2016-03-27.
 */

class Calculator {
    int left, right;

    public void setOprands(int left, int right) {
        if (right == 0) {
            throw new IllegalArgumentException("두번째 인자는 0 안 돼");
        }
        this.left = left;
        this.right = right;
    }

    public void divide() {
        if (right == 0) {
            //밑의 e로 보내준다.
            throw new ArithmeticException("0으로 못 나눔");
        }
        try {
            System.out.print("계산결과는 ");
            System.out.print(this.left / this.right);
            System.out.print(" 입니다.");
        } catch (Exception e) {
            System.out.println("\n\ne.getMessage()\n" + e.getMessage());
            System.out.println("\n\ne.toString()\n" + e.toString());
            System.out.println("\n\ne.printStackTrace()");
            e.printStackTrace();
        }
    }
}

class DivideException extends Exception {
    DivideException(){
        super();
    }
    DivideException(String message){
        super(message);
    }
}
class Calculator2{
    int left, right;
    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    }
    public void divide() throws DivideException{
        if(this.right == 0){
            throw new DivideException("0으로 나누는 것은 허용되지 않습니다.");
        }
        System.out.print(this.left/this.right);
    }
}

public class ExceptionDemo3 {
    public static void main(String[] args) {
        System.out.println("*************STEP1*************");
        Calculator c1 = new Calculator();
        c1.setOprands(10, 0);
        //try {
            c1.divide();
        /*} catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }*/
        System.out.println("*************STEP1 END*************");



        System.out.println("*************STEP2*************");
        Calculator2 c2 = new Calculator2();
        c2.setOprands(10, 0);
        try {
            c2.divide();
        } catch (DivideException e) {
            e.printStackTrace();
        }
        //exception(checked) - 사용자에게 문제를 해결할 기회를 줄 때
        //runtimeexception(uncheck) - 그냥 프로그램을 종료시킬 때
        System.out.println("*************STEP2 END*************");
    }
}
