package a0326.grade;

import java.util.ArrayList;
import java.util.Scanner;

public class grademanager {
    private static ArrayList<student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int idcounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== 성적 관리 프로그램 ===");
            System.out.println("1. 성적 추가");
            System.out.println("2. 성적 조회");
            System.out.println("3. 성적 수정");
            System.out.println("4. 성적 삭제");
            System.out.println("5. 종료");
            System.out.print("선택: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addstudent();
                    break;
                case 2:
                    viewstudent();
                    break;
                case 3:
                    updatestudent();
                    break;
                case 4:
                    removestudent();
                    break;
                case 5:
                    System.out.println("프로그램 종료");
                    System.exit(5);
                    // return; 종료 위에랑 같은 효과
                default:
                    break;
            }
        }
    }

    // 1.번 성적추가
    private static void addstudent() {
        System.out.println("학생 이름:");
        String name = scanner.nextLine();
        System.out.println("점수 입력:");
        int score = scanner.nextInt();

        // 차선책
        // scanner.nextLine();
        // student student = new student();
        // student.setId(idcounter++);
        // student.setName(name);

        student student = new student(idcounter++, name, score);
        students.add(student);
        System.out.println("성적이 추가되었습니다.");
    }

    // 2번 성적 조회
    private static void viewstudent() {
        if (students.isEmpty()) { // 학생이 없으면(ArrayList가 비어있으면)
            System.out.println("등록된 학생이 없습니다.");
        } else {
            System.out.println("\n-----성적-----");
            for (student s : students) {
                s.display(); // 직접만든 출력메서드
                // System.out.println(s.toString());
            }
        }
    }

    // 3번 성적 수정
    private static void updatestudent() {
        System.out.println("수정할 학생 id 입력");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (student student : students) {
            if (student.getId() == id) {
                System.out.print("새로운 점수 입력:");
                int newscore = scanner.nextInt();
                scanner.nextLine();
                student.setScore(newscore);
                System.out.println("성적이 수정되었습니다");
                return; // return 써주지 않으면 학생을 찾아 수정후에도 끝까지 루프를 실행
            }
        }
        System.out.println("해당 학생이 없습니다.");
    }

    // 4번 성적 삭제
    private static void removestudent() {
        System.out.println("삭제할 학생 id 입력");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                System.out.println("성적이 삭제되었습니다");
                return;
            }
        }
        System.out.println("해당 학생이 없습니다.");
    }
}