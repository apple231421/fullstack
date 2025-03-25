package a0325.abstract1;

public class main1 {
    public static void main(String[] args) {

        animal dog = new dog("buddy ");
        dog.makesound();
        dog.eat();
        // animal 클래스가 추상클래스 이므로 직접인스턴스를 만들수 없고
        // dog같은 하위 클래스에서 인스턴스를 만들어야 합니다.

        animal cat = new cat("나비 ");
        cat.makesound();
        cat.eat();
    }
}
