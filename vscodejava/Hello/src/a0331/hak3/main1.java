package a0331.hak3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        // 학생수를 입력
        System.out.println("학생 수를 입력하세요");
        int n = sc.nextInt();
        sc.nextLine(); // 개행문자

        // 학생 정보 입력
        for (int i = 0; i < n; i++) {
            System.out.print("학생 이름: ");
            String name = sc.nextLine();
            System.out.print("학생 나이: ");
            int age = sc.nextInt();
            System.out.print("학생 학번: ");
            int studentId = sc.nextInt();
            System.out.println();
            sc.nextLine(); // 개행 문자 소비

            // students[i] = new Student(name, age, studentId); // 정상적으로 객체 생성
            students.add(new Student(name, age, studentId));
        }
        // 정렬 옵션 선택
        System.out.println("정렬 기준을 선택하세요");
        System.out.println("1. 이름");
        System.out.println("2. 나이");
        System.out.println("3. 학번");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                // 이름 순으로 정렬
                Collections.sort(students, new NameComparator());
                break;
            case 2:
                // 나이 순으로 정렬
                Collections.sort(students, new AgeComparator());
                break;
            case 3:
                // 학번 순으로 정렬
                Collections.sort(students, new NumComparator());
                break;
            default:
                break;
        }

        System.out.println("정렬된 학생 목록");
        for (Student student : students) {
            System.out.println(student);
        }
        sc.close(); // Scanner 닫기
    }

}

class Student {
    private String name;
    private int age;
    private int studentid;

    // 생성자 추가
    public Student(String name, int age, int studentid) {
        this.name = name;
        this.age = age;
        this.studentid = studentid;
    }

    // Getter/Setter
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

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", studentid=" + studentid + "}";
    }

}

class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }

}

class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }

}

class NumComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getStudentid(), o2.getStudentid());
    }

}
