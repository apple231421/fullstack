package 렌트카;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("프로그램을 시작합니다");
        Menu menu = MainMenu.getInstance();

        while (menu != null) {
            menu.print();
            menu = menu.next();
        }
        System.out.println("프로그램이 종료됩니다.");
    }
}

interface Menu {
    void print(); // 메뉴 출력

    Menu next(); // 다음 메뉴로 이동
    // next 이름에 메서드 , 메뉴타입의 객체 반환

}
