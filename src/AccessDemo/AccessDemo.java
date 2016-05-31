package AccessDemo;

/**
 * Created by ksk on 2016-03-26.
 */
class A {
    public String y() {
        return "y()";
    }

    private String z() {
        return "z()";
    }

    public String x() {
        return z();
    }
}

public class AccessDemo {
    public static void main(String[] args) {
        System.out.println("*************STEP1*************");
        A a = new A();
        System.out.println(a.y());
        // 아래 코드는 오류가 발생한다.
        // private은 class 밖에서는 접근할 수 없기 때문이다.
        // 사용하는 이유는 사용자(개발자)에게 사용할 수 있는 메소드와 사용할 수 없는 메소드를 구분 짓게 하기 위함이다.
        //System.out.println(a.z());
        System.out.println(a.x());

        //public - 모두 접근 가능
        //protected - 다른 패키지면 접근이 안 되지만 상속관계이면 접근 가능
        //default - 같은 패키지에서만 접근 가능
        //private - 같은 클래스에서만 접근 가능
        System.out.println("*************STEP1 END*************");
    }
}
