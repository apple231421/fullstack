package a0326.인터페이스;

interface Flyable {
    void fly();
}

interface Swimable {
    void swim();
}

// 여러개의 인터페이스를 구현한 클래스
class Bird implements Flyable, Swimable {

    @Override
    public void fly() {
        System.out.println("새가 날아갑니다.");
    }

    @Override
    public void swim() {
        System.out.println("새가 물에서 헤엄칩니다.");
    }

}

public class mutilnterfaceEx {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly();
        bird.swim();
    }
}
