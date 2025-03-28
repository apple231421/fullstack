package a0328.book;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        // bookDAO 객체 생성하여 도서 관련 기능을 처리
        bookDAO test = new bookDAO();
        // 사용자 입력을 받기 위한 Scanner 객체
        Scanner sc = new Scanner(System.in);

        // 무한 루프를 통해 메뉴를 계속 표시
        while (true) {
            // 사용자에게 보여줄 메뉴 출력
            System.out.println("===== 📚 도서 관리 시스템 =====");
            System.out.println("1. 도서 정보 입력");
            System.out.println("2. 도서 정보 삭제");
            System.out.println("3. 도서 정보 검색");
            System.out.println("4. 도서 정보 수정");
            System.out.println("5. 전체 도서 목록 보기");
            System.out.println("6. 도서 목록을 파일로 저장");
            System.out.println("7. 파일에서 도서 목록 불러오기");
            System.out.println("0. 프로그램 종료");
            System.out.print(">>");
            
            // 사용자 입력을 정수형으로 받음
            int choice;
            try {
                choice = sc.nextInt(); // 사용자 입력값을 choice 변수에 저장
            } catch (Exception e) {
                // 예외 처리: 만약 정수가 아닌 값을 입력하면 choice 값을 -1로 설정
                choice = -1;
            }

            // 사용자가 선택한 메뉴에 맞는 작업을 수행
            if (choice == 1) {
                // 도서 정보 입력
                test.bookInsert();
            } else if (choice == 2) {
                // 도서 정보 삭제
                test.bookDelete();
            } else if (choice == 3) {
                // 도서 정보 검색
                test.bookSearch();
            } else if (choice == 4) {
                // 도서 정보 수정
                test.bookUpdata();
            } else if (choice == 5) {
                // 전체 도서 목록 보기
                test.lookAll();
            } else if (choice == 6) {
                // 도서 목록을 파일로 저장
                try {
                    test.dataSave(); // 파일에 도서 목록을 저장
                } catch (Exception e) {
                    e.printStackTrace(); // 예외가 발생하면 스택 트레이스를 출력
                }
            } else if (choice == 7) {
                // 파일에서 도서 목록 불러오기
                test.bookLoad();
            } else if (choice == 0) {
                // 프로그램 종료
                System.out.println("종료합니다");
                sc.close(); // Scanner 객체 닫기
                System.exit(0); // 프로그램 종료
               
            } else {
                // 잘못된 입력에 대한 처리
                sc.nextLine();
                System.out.println("잘못된 값입니다");
            }
        }
    }
}
