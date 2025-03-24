package a0324.업캐스팅;

public class upcastingtest {
    public static void main(String[] args) {
        square s = new square();
        s.name = "정사각형";
        triangle t = new triangle();
        t.name = "삼각형";
        circle c = new circle();
        c.name = "원";

        shape[] shapes = { s, t, c }; // 부모의 타입으로 업 캐스팅 배열 생성

        for (int i = 0; i < shapes.length; i++) {
            System.out.printf("%d인 인덱스의 도형: %s\n", i, shapes[i].name);
        }
    }
}
// 상속 관계가 정의된 자식 객체는 부모의 타입으로 해석, 즉 업캐스팅 될 수 있습니다.
// 서로다른 자식 객체를 부모의 타입으로 묶어 관리 할 수 있다.

// 부모클래스
class shape {// 도형
    String name;
}

// 자식클래스
class square extends shape {
}

class triangle extends shape {
}

class circle extends shape {
}
