package a0320;

public class class4 {
    public static void main(String[] args) {
        student s = new student("이순신", 3, "소프트웨어공학과");
        student s1 = new student("홍길동", 2, "산업공학과");
        System.out.printf("이름:%s 학년:%d 학과:%s\n",s.name,s.grade,s.department);
        System.out.printf("이름:%s 학년:%d 학과:%s",s1.name,s1.grade,s1.department);
    }

}

class student {

    String name;
    int grade;
    String department;

    public student(String n, int g, String d) {
        name = n;
        grade = g;
        department = d;
    }
}