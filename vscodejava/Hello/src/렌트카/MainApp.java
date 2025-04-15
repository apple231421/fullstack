package 렌트카;

import java.io.IOException;

// 프로그램 시작 클래스
public class MainApp {
    public static void main(String[] args) {
        System.out.println("프로그램을 시작합니다");

        // 기본 차량 데이터가 없으면 최초 1회 실행
        try {
            Car.maincar();
        } catch (IOException | InterruptedException e) {
            System.out.println("기본 차량 초기화 실패: " + e.getMessage());
        }

        // 메인 메뉴 인스턴스 가져오기
        Menu menu = MainMenu.getInstance();

        // 메뉴가 null이 될 때까지 반복
        while (menu != null) {
            menu.print(); // 현재 메뉴 출력
            menu = menu.next(); // 사용자 입력 후 다음 메뉴로 이동
        }

        System.out.println("프로그램이 종료됩니다.");
    }
}

// 메뉴 구조를 정의한 인터페이스 (모든 메뉴는 이 인터페이스를 구현해야 함)
interface Menu {
    void print(); // 메뉴 출력 기능

    Menu next(); // 사용자 입력 처리 후 다음 메뉴로 전환
}
