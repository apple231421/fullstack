package a0325.car;

abstract class Vehicle {
    String name;

    // 생성자
    public Vehicle(String name) {
        this.name = name;
    }

    // 추상 메서드 (각 자식 클래스에서 구현해야 함)
    abstract void move();

    // 일반 메서드
    void displayInfo() {
        System.out.println("이 차량은 " + name + " 입니다.");
    }
}

// Car 클래스 (Vehicle 상속)
class Car extends Vehicle {
    public Car(String name) {
        super(name);
    }

    @Override
    void move() {
        System.out.println("자동차 " + name + "이(가) 도로를 달립니다.");
    }
}

// Bicycle 클래스 (Vehicle 상속)
class Bicycle extends Vehicle {
    public Bicycle(String name) {
        super(name);
    }

    @Override
    void move() {
        System.out.println("자전거 " + name + "이(가) 페달을 밟으며 이동합니다.");
    }
}

// 메인 클래스
public class Main {
    public static void main(String[] args) {
        // 객체 생성
        Car myCar = new Car("소나타");
        Bicycle myBike = new Bicycle("삼천리 자전거");

        // 메서드 호출
        myCar.displayInfo();
        myCar.move();

        System.out.println(); // 줄바꿈

        myBike.displayInfo();
        myBike.move();
    }
}