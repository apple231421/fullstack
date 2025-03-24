package a0324.rpg2;

public class area1 {
    public static void main(String[] args) {
        square s = new square();
        s.name = "정사각형";
        s.length = 3;
        triangle t = new triangle();
        t.name = "삼각형";
        t.base = 4;
        t.height = 3;
        circle c = new circle();
        c.radisu = 4;
        c.name = "원";

        shape[] shapes = { s, t, c }; // 부모의 타입으로 업 캐스팅 배열 생성

        for (int i = 0; i < shapes.length; i++) {
            System.out.printf("%s의 넓이 : %.2f\n", shapes[i].name, shapes[i].area());
        }
    }
}
// 상속 관계가 정의된 자식 객체는 부모의 타입으로 해석, 즉 업캐스팅 될 수 있습니다.
// 서로다른 자식 객체를 부모의 타입으로 묶어 관리 할 수 있다.

// 부모클래스
class shape {// 도형
    String name;

    double area() {
        return 0;
    }
}

// 자식클래스
class square extends shape {
    int length;

    double area() {
        return length * length;
    }
}

class triangle extends shape {
    int base;
    int height;

    double area() {
        return base * height * 0.5;
    }
}

class circle extends shape {
    int radisu;

    double area() {
        return radisu * radisu * Math.PI;
    }
}
