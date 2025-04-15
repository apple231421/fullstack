package 렌트카;

import java.util.Scanner;

abstract class AbstractMenu implements Menu {

    // 화면에 출력할 메뉴 텍스트 (예: "1. 등록하기\n2. 삭제하기...")
    protected String menuText;

    // 이전 메뉴 객체 (뒤로가기 등을 위해 사용됨)
    protected static Menu prevMenu;

    // 사용자 입력을 받기 위한 Scanner (모든 메뉴 클래스가 공유)
    protected static final Scanner sc = new Scanner(System.in);

    // 메뉴 텍스트와 이전 메뉴 설정
    public AbstractMenu(String menuText, Menu prevMenu) {
        this.menuText = menuText;
        this.prevMenu = prevMenu;
    }

    // 화면에 메뉴 텍스트를 출력하고 사용자 입력을 유도
    public void print() {
        System.out.println("\n" + menuText); // 메뉴 출력
        System.out.print("메뉴를 선택하세요: ");
    }

    // 이전 메뉴를 변경할 수 있도록 설정하는 메서드
    public void setPrevMenu(Menu prevMenu) {
        this.prevMenu = prevMenu;
    }
}
