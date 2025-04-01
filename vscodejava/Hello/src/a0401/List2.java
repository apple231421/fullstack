package a0401;

import java.util.ArrayList;
import java.util.List;

public class List2 {
    public static void main(String[] args) {
        // ArrayList 생성
        List<Student> studentList = new ArrayList<>();

        // 객체추가
        studentList.add(new Student(101, "Alice", 20));
        studentList.add(new Student(102, "Bob", 22));
        studentList.add(new Student(103, "Charlie", 21));

        System.out.println("student List 출력");
        printList(studentList);

        // 1번 인덱스를 가져온 뒤 프린트해보세요
        Student s = studentList.get(1);
        System.out.println(s);

        // 1번 인덱스의 이름만 가져오기
        String n = studentList.get(1).getName();
        System.out.println(n);

        // 모든 student의 이름만 출력
        System.out.println("모든학생 이름 출력");
        for (Student name : studentList) {
            System.out.println(name.getName());
        }

        // 새로운 학생 추가
        System.out.println("새로운 학생 추가");
        studentList.add(new Student(104, "David", 23));
        System.out.println(studentList);

        // 데이터 변경 102,"Robert", 25 updateStudent 메서드만들어서 변경
        System.out.println("102번 학생 데이터 변경");
        updateStudent(studentList, 102, "Robert", 25);
        printList(studentList);

        // 데이터 삭제
        System.out.println("\n특정 학생 삭제");
        deleteStudent(studentList, 103);
        printList(studentList);

        // 특정 학생 검색
        System.out.println("\n 특정 학생 검색");
        Student searchedStudent = findStudentById(studentList, 104);
        System.out.println(searchedStudent != null ? searchedStudent : "학생을 찾을 수 없습니다.");
    }

    private static Student findStudentById(List<Student> studentList, int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    private static void deleteStudent(List<Student> studentList, int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                System.out.println("학생 ID : " + id + "의 정보가 삭제되었습니다");
                return;
            }
        }
        System.out.println("학생 ID : " + id + " 을 찾을 수 없습니다");
    }

    // 학생정보 업데이트
    private static void updateStudent(List<Student> studentList, int id, String newName, int newAge) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                // Update the student information
                Student updatedStudent = new Student(id, newName, newAge);
                studentList.set(i, updatedStudent);
                System.out.println("학생 ID : " + id + " 학생의 나이 : " + newAge + "로 정보가 수정되었습니다");
                return;
            }
        }
        System.out.println("학생 ID : " + id + " 을 찾을 수 없습니다");
    }

    private static void printList(List<Student> studentList) {
        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}

class Student {

    private int id;
    private String name;
    private int age;

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

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
