package ObjectClassDemo;

/**
 * Created by ksk on 2016-03-27.
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

    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }

    public String toString() {
        return super.toString() + "left:" + this.left + ", right:" + this.right;
    }
}


class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    //매개변수가 Object obj인 이유
    //클래스의 다형성을 이용한 것이다.
    //Student클래스는 Object클래스의 자식이기 때문에 부모는 자식을 참조할 수 있다는 특성에 의해 가능
    //자식의 equals메소드에만 접근하겠다는 뜻
    //equals는 hashcode와 많이 사용된다.
    public boolean equals(Object obj) {//매개변수를 Object로 하는 이유는 어떤 데이터타입이 들어올지 예상이 안 될때 사용하는 관례이다.
        //Student의 name을 사용하기 위해선 Student 데이터타입으로 바꿔야 한다.
        //다시 Student 데이터타입의 변수에 할당을 하기 위해서는 형변환이 필요하다
        Student _obj = (Student) obj;
        return name == _obj.name;
    }
}

//Cloneable를 구현한 이유는 vm에게 이것은 복제 가능한 클래스라는 것을 알려주기 위해
class Student2 implements Cloneable {
    String name;

    Student2(String name) {
        this.name = name;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ObjectClassDemo {
    public static void main(String[] args) {
        System.out.println("*************STEP1*************");
        //자바의 모든 클래스들의 시조

        Calculator c1 = new Calculator();
        c1.setOprands(10, 20);
        //식별자를 확인할 수 있다
        //Calculator@4554617c
        //식별자 - 4554617c
        System.out.println(c1.toString());
        System.out.println("*************STEP1 END*************");


        System.out.println("*************STEP2*************");
        //밑의 인스턴스 둘은 다른 객체이기 때문에 밑의 두가지 방법 모두 false를 반환한다.
        //그러나 두번째 방법을 재정의하여 반환값을 달리할 수 있다.
        Student s1 = new Student("egoing");
        Student s2 = new Student("egoing");

        //==는 원시데이터형(byte, short, int, long, float, double, boolean, char)에서만 사용해라
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println("*************STEP2 END*************");


        System.out.println("*************STEP3*************");
        //객체가 소멸될 때 일어나야 될 작업을 구현할 때 finalize를 사용한다.
        //이 메소드는 사용을 만류하고 있다.
        System.out.println("*************STEP3 END*************");


        System.out.println("*************STEP4*************");
        Student2 s3 = new Student2("egoing");
        try {
            Student2 s4 = (Student2) s3.clone();
            System.out.println(s3.name);
            System.out.println(s4.name);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("*************STEP4 END*************");
    }
}
