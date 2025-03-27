public class class1 {
    public static void main(String[] args) {

        cat c = new cat(); // cat이라는 객체를 생성

        c.name = "네로";
        c.breads = "페르시안";
        c.weight = 4.55;

        // 객체상태(필드) 출력
        System.out.printf("이름: %s\n", c.name); // '.' 닷연산자 - 객체를 접근하기 위한 연산자
        System.out.printf("품종: %s\n", c.breads);
        System.out.printf("몸무게: %s kg\n", c.weight);
    }
}

class cat {
    String name; // 이름 -인스턴스변수
    String breads; // 품종
    double weight; // 체중

    void claw() {
        System.out.println("할퀴기");
    }

    void meow() {
        System.out.println("야옹");
    }
}