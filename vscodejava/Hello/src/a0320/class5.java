

public class class5 {
    public static void main(String[] args) {
        Person person = new Person("홍길동", 31);
        System.out.printf("이름 : %s 나이 : %d", person.name, person.age);
    }
}

class Person {
    String name;
    int age;

    public Person(String n, int a) {
        name = n;
        age = a;
    }
}
