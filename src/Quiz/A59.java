package Quiz;

/**
 * Created by ksk on 2016-04-09.
 */
public class A59 {
    public static final String FOO = "foo";

    public static void main(String[] args) {
        A59 b = new A59();
        Sub s = new Sub();
        System.out.println(A59.FOO);
        System.out.println(Sub.FOO);
        System.out.println(b.FOO);
        System.out.println(s.FOO);
        System.out.println(((A59) s).FOO);
        //statick은 인스턴스로 접근하거나 인스턴스 없이 접근가능
        //5번째는 s를 A59로 캐스팅했으므로 foo를 바라보게 된다.
    }
}

class Sub extends A59 {
    public static final String FOO = "bar";
}