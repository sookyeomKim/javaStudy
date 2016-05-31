package Quiz;

/**
 * Created by ksk on 2016-04-08.
 */

class Animal {
    public String noise() {
        return "peep";
    }
}

class Dog extends Animal {
    public String noise() {
        return "bark";
    }
}

class Cat extends Animal {
    public String noise() {
        return "meow";
    }
}

public class B36 {
    public static void main(String[] args) {
        Animal animal = new Dog();
        System.out.println(animal.noise());
        Cat cat = (Cat) animal;//같은 자식끼리 캐스팅 될 수 없다.
        System.out.println(cat.noise());
    }
}
