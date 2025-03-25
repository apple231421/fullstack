package a0325.abstract1;

// 추상크랠스
// abstract 키워드가 붙은 클래스
// 객체를 직접 정의하고 하위클래스에서 구현하도록 강제하는 역할
// 일반메서드 추상메서드(선언만 있고 구현은 없는 메서드)를 가질수있다

abstract class animal {
    String name;

    public animal(String name) {
        this.name = name;

    }

    abstract void makesound();

    void eat() {
        System.out.println(name + "is eating");
    }

}

class dog extends animal {

    public dog(String name) {
        super(name);
    }

    @Override
    void makesound() {
        System.out.println(name + "왈왈!!");

    }

}

class cat extends animal {

    public cat(String name) {
        super(name);

    }

    @Override
    void makesound() {
        System.out.println(name + "야옹!!");
    }

}

class bird extends animal {

    public bird(String name) {
        super(name);

    }

    @Override
    void makesound() {
        System.out.println(name + "짹짹!!");

    }

}