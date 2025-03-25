package a0325.abstract2;

abstract class shape {
    String type;

    public shape(String type) {
        this.type = type;
    }

    abstract double area();

    abstract double length();
}

class circle extends shape {

    int r;

    public circle(int r) {
        super("원");
        this.r = r;
    }

    @Override
    double area() {
        return r * r * Math.PI;
    }

    @Override
    double length() {
        return 2 * Math.PI * r;
    }

    @Override
    public String toString() {
        return "shape [type=" + type + ", r=" + r + "]";
    }

}

class rectangle extends shape {
    int width, height;

    public rectangle(int width, int height) {
        super("사각형");
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }

    @Override
    double length() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "rectangle [type=" + type + ", width=" + width + ", height=" + height + "]";
    }

}

public class shapeex {
    public static void main(String[] args) {
        // shape[] shapes = new shape[2];
        // shapes[0] = new circle(10);
        // shapes[1] = new rectangle(5, 5);
        // for (shape s : shapes) {
        // System.out.println(s);
        // System.out.println("넓이:" + s.area() + " 둘레" + s.length());
        // }

        shape c = new circle(10);
        System.out.println(c);
        System.out.println("넓이:" + c.area() + " 둘레" + c.length());
        shape r = new rectangle(5, 5);
        System.out.println(r);
        System.out.println("넓이:" + r.area() + " 둘레" + r.length());
        // 다형성 - shape는 추상클래스이기 때문에 shape[] circle과
        // rectangle 객체 모두 담을 수 있다.
        // 각 객체는 area()와 lenght()메서드를 각기 다르게 구현하므로
        // 해당 메서드가 호출될때 다르게 동작합니다.

        // 추상클래스와 상속: shape는 추상클래스이고, circle과 rectangle은
        // 이를 상속 받아 자신만의 방법으로 넓이와 돌레를 계산합니다.
    }
}
