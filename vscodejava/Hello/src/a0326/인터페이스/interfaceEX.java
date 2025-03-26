package a0326.인터페이스;

interface Animal {
    void makesound(); // 추상메서드 (abstract을 안써도 생략이 가능함)
    // 일반메서드 사용금지
}

// 인터페이스를 구현하는 클래스
class Dog implements Animal {

    @Override
    public void makesound() {
        System.out.println("멍멍!");

    }

}

class Cat implements Animal {

    @Override
    public void makesound() {
        System.out.println("냥냥!");

    }

}

public class interfaceEX {
    public static void main(String[] args) {
        // Animal ani = new Animal(); 인터페이스는 추상클래스와 마찬가지로 자신을 객체로 만들지 못함
        Animal dog = new Dog();
        Animal cat = new Cat();
        // main() 메서드에서 다형성을 필요하여 Animal 타입으로 Dog Cat객체를 사용할 수 있음.

        dog.makesound();
        cat.makesound();
    }
}
