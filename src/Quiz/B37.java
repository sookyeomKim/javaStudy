package Quiz;

/**
 * Created by ksk on 2016-04-08.
 */
class Foo {
    public int a = 3;

    public void addFive() {
        a += 5;
        System.out.println("f");
    }
}

class Bar extends Foo {
    public int a = 8;

    public void addFive() {
        this.a += 5;
        System.out.println("b");
    }
}

public class B37 {
    public static void main(String[] args) {
        Foo f = new Bar();
        f.addFive();
        System.out.println(f.a);
        //b
        //3
        //b는 Bar에서 오버라이딩 했으므로 당연
        //3은 인스턴스 f의 데이터타입이 Foo이므로 Foo의 멤버변수인 a의 3을 불러오고
        //Bar에서 오버라이딩한 메소드 내용의 this.a는 Bar의 멤버변수인 a에 영향을 주므로
        //Foo의 멤버변수 a에 영향을 주지 않아 그대로 3이 출력
    }
}
