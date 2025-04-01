package a0401.ramda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ramda3 {
    public static void main(String[] args) {
        List<Person> peoples = new ArrayList<>();

        Person p1 = new Person(1, "허준석", 30);
        Person p2 = new Person(2, "김진짜", 33);
        Person p3 = new Person(3, "박성춘", 31);

        peoples.add(p1);
        peoples.add(p2);
        peoples.add(p3);
        peoples.forEach(p -> System.out.println(p));
        System.out.println();

        // 나이순
        Collections.sort(peoples, (pp1, pp2) -> pp1.getAge() - pp2.getAge());
        peoples.forEach(p -> System.out.println(p));
        System.out.println();

        // 이름순
        // .reversed() 역순
        // Collections.sort(peoples, (pp1, pp2) ->
        // pp1.getName().compareTo(pp2.getName()));
        // peoples.forEach(p -> System.out.println(p));
        // System.out.println();

        peoples.sort(Comparator.comparing(Person::getName));
        peoples.forEach(p -> System.out.println(p));

        // 아이디순
        Collections.sort(peoples, (pp1, pp2) -> Integer.compare(pp1.getId(), pp2.getId()));
        peoples.forEach(p -> System.out.println(p));

        // peoples.sort(Comparator.comparingInt(Person::getAge));
        // Collections.sort(peoples, (pp1, pp2) -> Integer.compare(pp1.getAge(),
        // pp2.getAge()));
    }
}

class Person {
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

}