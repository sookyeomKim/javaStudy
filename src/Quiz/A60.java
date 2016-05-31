package Quiz;

/**
 * Created by ksk on 2016-04-09.
 */


public interface A60 {
    public void m1();
}

/*class B implements A60 {
//A60의 메소드를 오버라이딩하지 않아 에러
}*/

class C implements A60 {
    @Override
    public void m1() {

    }
}

/*class D implements A60{
    //오버라이딩이 아닌 오버로딩을 하고 있으므로 A60의 메소드를 오버라이딩 하지 않아 에러
    @Override
    public void m1(int x) {

    }
}*/

abstract class E implements A60{
//추상으로 선언해주어 인터페이스의 메소드 구현을 미뤘다
}

abstract class F implements A60{
    @Override
    public void m1() {

    }
}

abstract class G implements A60{
    //추상으로 선언해주어 인터페이스의 메소드 구현을 미뤘다
    public void m1(int x) {

    }
}