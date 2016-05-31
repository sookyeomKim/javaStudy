package ExceptionDemo2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ksk on 2016-03-27.
 */

class B {
    void run() {
        BufferedReader bReader = null;
        String input = null;
        try {
            bReader = new BufferedReader(new FileReader("out.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            input = bReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(input);
    }
}

class C {
    void run() {
        B b = new B();
        b.run();
    }
}

//out.txt 파일을 찾을 수 없는 상황은 B.run입장에서 해결할 수 잇는게 아니기 때문에
//이걸 해결할 수 있는 main 으로 예외를 넘긴다.
//B에서 처리한 예외처리를 떠넘길 수 있다.

class B2{
    void run() throws IOException, FileNotFoundException{
        BufferedReader bReader = null;
        String input = null;
        bReader = new BufferedReader(new FileReader("out.txt"));
        input = bReader.readLine();
        System.out.println(input);
    }
}
class C2{
    void run(){
        B2 b = new B2();
        try {
            b.run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


public class ExceptionDemo2 {
    public static void main(String[] args) {
        System.out.println("*************STEP1*************");
        BufferedReader bReader = null;
        String input = null;
        try {
            bReader = new BufferedReader(new FileReader("out.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            input = bReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(input);
        System.out.println("*************STEP1 END*************");


        System.out.println("*************STEP2*************");
        C c = new C();
        c.run();

        C2 c2 = new C2();
        c.run();

        //throws는 예외를 넘길 때
        //throw는 예외를 직접 만들 때
        System.out.println("*************STEP2 END*************");
    }
}
