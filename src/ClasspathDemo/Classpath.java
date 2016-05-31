package ClasspathDemo;

/**
 * Created by ksk on 2016-03-25.
 */

public class Classpath {
    public static void main(String[] args) {
        System.out.println("*************STEP1*************");
        //컴파일 될 경우 그 파일안에 있는 모든 클래스가 .class파일로 만들어진다.

        //java -classpath "경로;경로" 메인클래스이름름

        //java 메인클래스이름 === java -classpath "." 메인클래스이름름

        //-classpath를 환경변수로 지정할 수 있다.
      System.out.println("*************STEP1 END*************");
    }
}
