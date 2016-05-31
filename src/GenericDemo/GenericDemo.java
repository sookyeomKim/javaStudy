package GenericDemo;

/**
 * Created by ksk on 2016-03-27.
 */
/*class StudentInfo{
    public int grade;
    StudentInfo(int grade){ this.grade = grade; }
}
class StudentPerson{
    public StudentInfo info;
    StudentPerson(StudentInfo info){ this.info = info; }
}
class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}
class EmployeePerson{
    public EmployeeInfo info;
    EmployeePerson(EmployeeInfo info){ this.info = info; }
}*/


/*class StudentInfo {
    public int grade;

    StudentInfo(int grade) {
        this.grade = grade;
    }
}

class EmployeeInfo {
    public int rank;

    EmployeeInfo(int rank) {
        this.rank = rank;
    }
}

class Person {
    public Object info;

    Person(Object info) {
        this.info = info;
    }
}*/


/*abstract class info {
    public abstract int getLevel();
}*/
interface info {
    public int getLevel();
}

class StudentInfo implements info {
    public int grade;

    StudentInfo(int grade) {
        this.grade = grade;
    }

    @Override
    public int getLevel() {
        return this.grade;
    }
}

class EmployeeInfo implements info {
    public int rank;

    EmployeeInfo(int rank) {
        this.rank = rank;
    }

    @Override
    public int getLevel() {
        return this.rank;
    }
}

class Person<T, S> {
    public T info;
    public S id;

    Person(T info, S id) {
        this.info = info;
        this.id = id;
    }

    public <U> void printInfo(U info) {
        System.out.println(info);
    }
}

class Person2<T extends info> {
    public T info;

    Person2(T info) {
        this.info = info;
    }
}


public class GenericDemo {
    public static void main(String[] args) {
        //내부에서 사용할 데이터 타입을 외부에서 지정하는 기법
        System.out.println("*************STEP1*************");
        /*StudentInfo si = new StudentInfo(2);
        StudentPerson sp = new StudentPerson(si);
        System.out.println(sp.info.grade); // 2
        EmployeeInfo ei = new EmployeeInfo(1);
        EmployeePerson ep = new EmployeePerson(ei);
        System.out.println(ep.info.rank); // 1*/

        //rank는 int형인데 값은 string값을 받고 있다.
        //원래 에러가 나야하지만 컴파일러가 이를 못 찾고 있다
        //이래서 제네릭을 쓴다 - 타입 안전성
        /*Person p1 = new Person("부장");
        EmployeeInfo ei = (EmployeeInfo) p1.info;
        System.out.println(ei.rank);*/

        /*Person<EmployeeInfo> p1 = new Person<EmployeeInfo>(new EmployeeInfo(1));
        EmployeeInfo ei1 = p1.info;
        int ei11 = p1.info.rank;
        System.out.println(ei1.rank); // 성공

        Person<String> p2 = new Person<String>("부장");
        String ei2 = p2.info;*/
        //System.out.println(ei2.rank); // 컴파일 실패
        //1.컴파일 단계에서 오류가 검출된다.
        //2.중복의 제거와 타입 안전성을 동시에 추구할 수 있게 된다.
        System.out.println("*************STEP1 END*************");


        System.out.println("*************STEP2*************");
        //제네릭은 참조형 데이터타입만 올 수 있다.  ex) new ~();
        //기본 데이터타입은 올 수 없다.
        //Person<EmployeeInfo, int> p1 = new Person<EmployeeInfo, int>(new EmployeeInfo(1), 1);
        //int를 랩퍼클래스인 Integer로 변환시킨다.
        Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(new EmployeeInfo(1), 1);
        System.out.println(p1.info.rank);
        System.out.println(p1.id);

        //제네릭을 생략할 수도 있다.
        EmployeeInfo e = new EmployeeInfo(1);
        Integer i = new Integer(10);
        Person p2 = new Person(e, i);
        //System.out.println(p2.info.rank);
        System.out.println(p2.id);

        //메소드에도 제네릭을 적용할 수 있다.
        //어찌보면 javascript처럼 데이터타입에 구애받지 않고 자유롭게 사용할 수 있다.
        p1.<EmployeeInfo>printInfo(new EmployeeInfo(1));
        p1.printInfo(new EmployeeInfo(1));
        System.out.println("*************STEP2 END*************");


        System.out.println("*************STEP3*************");
        //덕분에 또 여러 데이터타입이 들어와 에러를 유발할 수 있기 때문에 java는 타입의 확장을 도입했다.
        Person2<EmployeeInfo> p3 = new Person2<EmployeeInfo>(new EmployeeInfo(10));
        Person2<StudentInfo> p4 = new Person2<StudentInfo>(new StudentInfo(10));
        System.out.println(p3.info.rank);
        System.out.println(p4.info.grade);
        System.out.println("*************STEP3 END*************");
    }
}
