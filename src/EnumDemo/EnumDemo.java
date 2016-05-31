package EnumDemo;

/**
 * Created by ksk on 2016-03-27.
 */

//컴파일러를 이용하여 에러찾기에 유용하도록 한다.
class Fruit {
    public static final Fruit APPLE = new Fruit();
    public static final Fruit PEACH = new Fruit();
    public static final Fruit BANANA = new Fruit();
}

//위 코드와 아래 코드는 같다.

enum Fruit2 {
    APPLE("red"), PEACH("pink"), BANANA("yellow");

    public String color;

    public String getColor() {
        return this.color;
    }

    Fruit2(String color) {
        System.out.println(this);
        this.color = color;
    }
}


class Company {
    public static final Company GOOGLE = new Company();
    public static final Company APPLE = new Company();
    public static final Company ORACLE = new Company();
}

enum Company2 {
    GOOGLE, APPLE, ORACLE
}


public class EnumDemo {
    public static void main(String[] args) {
        System.out.println("*************STEP1*************");
        //같은 사과라는 것에서 의미가 혼동되어 심각한 에러를 발생시킬 수 있는 상황을
        //이렇게 인스턴스화 시켜 다른 데이터타입의 상수를 만들어 컴파일러가 에러를 검출할 수 있도록 하여
        //최악의 상황을 막는다.
        /*if(Fruit.APPLE == Company.APPLE){
            System.out.println("과일 애플과 회사 애플이 같다.");
        }*/
        System.out.println("*************STEP1 END*************");


        System.out.println("*************STEP2*************");
        //enum - 서로 연관된 상수들의 집합
        //장점
        //1.코드가 단순해진다.
        //2.인스턴스 생성과 상속을 방지한다
        //3.키워드 enum을 사용하기 때문에 구현의 의도가 열거임을 분명하게 나타낼 수 있다.
        //4.단순히 상수의 열거가 아니라 각각의 상수에 대한 다양한 작업을 할 수 있다.
        Fruit2 type2 = Fruit2.APPLE;
        switch (type2) {
            case APPLE:
                System.out.println(57 + " kcal, color = " + Fruit2.APPLE.getColor());
                break;
            case PEACH:
                System.out.println(34 + " kcal, color = " + Fruit2.PEACH.color);
                break;
            case BANANA:
                System.out.println(93 + " kcal, color = " + Fruit2.BANANA.color);
                break;
        }
        System.out.println("*************STEP2 END*************");


        System.out.println("*************STEP3*************");
        for (Fruit2 f : Fruit2.values()) {
            System.out.println(f.getColor());
        }
        System.out.println("*************STEP3 END*************");
    }
}
