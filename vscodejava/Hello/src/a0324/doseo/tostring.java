package a0324.doseo;

// 모든 자바 클래스는 Object라는 클래스를 상속한다 보통은 생략
public class tostring extends Object {
    public static void main(String[] args) {
        person person = new person("홍길동", 25);
    }

}

class person {
    private String name;
    private int age;

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "person [name=" + name + ",age=" + age + "]";
    }
}

// 오버로딩과 오버라이디의 차이 예제로 만들어 오기
// this와 this()의 차이를 예제로 만들어 오시오