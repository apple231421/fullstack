package a0331.학습;

import java.util.ArrayList;
import java.util.Collections;
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
        // 삽입 정렬(이름 기준으로 오름차순)
        Collections.sort(students);

        System.out.println("정렬");
        for (Student student : students) {
            System.out.println(student);
        }
        sc.close(); // Scanner 닫기
    }

}

class Student implements Comparable<Student> {
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
        return "Student [name=" + name + ", age=" + age + ", studentid=" + studentid + "]";
    }

    @Override
    public int compareTo(Student o) {
        //나이,아이디를 기준으로 정렬하려면 int 사용못함
        // 숫자비교일경우 참조변수 변경해야함.
        return Integer.compare(this.age, o.age);
    }



    // 문자형일때
    // @Override
    // public int compareTo(Student o) {

    // return this.name.compareTo(o.name);
    // }
}
