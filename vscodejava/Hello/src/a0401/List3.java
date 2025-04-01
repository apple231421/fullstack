package a0401;

import java.util.ArrayList;
import java.util.List;

public class List3 {
    public static void main(String[] args) {
        // ArrayList 생성
        List<Student> studentList = new ArrayList<>();

        // 객체 추가
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
        System.out.println("모든 학생 이름 출력");
        studentList.stream().map(Student::getName).forEach(System.out::println);

        // 새로운 학생 추가
        System.out.println("새로운 학생 추가");
        studentList.add(new Student(104, "David", 23));
        printList(studentList);

        // 데이터 변경 102,"Robert", 25 updateStudent 메서드 만들기
        System.out.println("102번 학생 데이터 변경");
        updateStudent(studentList, 102, "Robert", 25);
        printList(studentList);

        // 데이터 삭제
        System.out.println("\n특정 학생 삭제");
        deleteStudent(studentList, 103);
        printList(studentList);

        // 특정 학생 검색
        System.out.println("\n특정 학생 검색");
        Student searchedStudent = findStudentById(studentList, 104);
        System.out.println(searchedStudent != null ? searchedStudent : "학생을 찾을 수 없습니다.");
    }

    private static Student findStudentById(List<Student> studentList, int id) {
        return studentList.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    private static void deleteStudent(List<Student> studentList, int id) {
        boolean removed = studentList.removeIf(student -> student.getId() == id);

        // 결과 출력
        System.out.println(removed ? "학생 ID " + id + " 정보가 삭제되었습니다" : "학생 ID " + id + " 정보가 없습니다");
    }

    private static void updateStudent(List<Student> studentList, int id, String newName, int newAge) {
        // Stream 사용하여 학생 찾기 및 업데이트
        boolean updated = studentList.stream().filter(student -> student.getId() == id).peek(student -> {
            student.setName(newName); // 이름 업데이트
            student.setAge(newAge);   // 나이 업데이트
        })
        .findFirst() // 첫 번째 요소만 찾으면 처리
        .isPresent(); // 요소가 존재하는지 확인

        System.out.println(updated ? "학생 ID " + id + " 정보가 수정되었습니다" : "학생 ID " + id + " 정보가 없습니다");
    }

    private static void printList(List<Student> studentList) {
        studentList.forEach(System.out::println);
    }

    // Student 클래스는 static으로 선언되어야 List3 클래스 외부에서 인스턴스화 가능
    static class Student {

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
}
