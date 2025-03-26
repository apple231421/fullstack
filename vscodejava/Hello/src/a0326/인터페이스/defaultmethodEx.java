package a0326.인터페이스;

interface Greeting {
    void sayHello();

    // java 8 이상부터 사용가능한 default 메서드
    default void sayGoodbye() {
        System.out.println("안녕히 가세요");
    }
}

class Person implements Greeting {

    @Override
    public void sayHello() {
        System.out.println("안녕히하세요");

    }

    // Person 클래스에만 존재하는 추가 메서드
    public void introduce() {
        System.out.println("저는 Person 클래스입니다.");
    }
}

public class defaultmethodEx {
    public static void main(String[] args) {
        Person person = new Person();
        person.sayGoodbye();
        person.sayHello();
        person.introduce();

        Greeting person1 = new Person();
        person1.sayGoodbye();
        person1.sayHello();
        // person1.introduce(); X 컴파일 에러남 - Greeting 타입에는 introduce()가 없어서 난다

        // 다운캐스팅 : 부모 ->자식타입으로 변환
        if (person1 instanceof Person) { // 부모 자식관계인지 물어보고
            ((Person) person1).introduce();
            // person1이 실제로는 person의 객체이므로, person으로 캐스팅하면 introduce() 호출가능

        }
    }
}
