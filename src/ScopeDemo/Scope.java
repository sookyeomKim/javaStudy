package ScopeDemo;

/**
 * Created by ksk on 2016-03-24.
 */

class C3 {
    int v = 10;

    void m() {
        int v = 20;
        System.out.println(this.v);
    }
}

public class Scope {
    static void a() {
        int i = 0;//지역변수
    }

    static int j;//전역변수

    static void b() {
        j = 0;
    }

    static void c() {
        int i = 0;
        d();
    }

    static void d() {
        //System.out.println(i);
    }

    public static void main(String[] args) {
        System.out.println("*************STEP1*************");
        for (int i = 0; i < 5; i++) {
            a();//a메소드 안의 i는 다른 scope에 속해있으므로 영향을 줄 수 없다.
            System.out.println(i);
        }
        System.out.println("*************STEP1 END*************");


        System.out.println("*************STEP2*************");
        for (j = 0; j < 5; j++) {//*javascript와 달리 java는 block scope여서 for문 안에 선언된 int는 for문 안에서만 유효한 지역변수가 된다
            /*b();*///a메소드 안의 i는 다른 scope에 속해있으므로 영향을 줄 수 없다.
            System.out.println(j);
        }
        System.out.println("*************STEP2 END*************");


        System.out.println("*************STEP3*************");
        int i = 1;
        c();
        //java는 정적 유효범위를 채택하고 있다.
        System.out.println("*************STEP3 END*************");


        System.out.println("*************STEP4*************");
        //java에서 this는 무조건 인스턴스 자신(클래스)를 지정한다
        //javascript의 this는 동적스크립트로써 선언 범위에 따라 그 지정범위가 달라진다.
        C3 c1 = new C3();
        c1.m();
        System.out.println("*************STEP4 END*************");
    }
}
