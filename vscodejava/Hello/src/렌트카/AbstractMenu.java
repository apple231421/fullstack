package 렌트카;

import java.util.Scanner;

abstract class AbstractMenu implements Menu {

    protected String menuText; // 기본문구
    protected static Menu prevMenu;

    protected static final Scanner sc = new Scanner(System.in);

    public AbstractMenu(String menuText, Menu prevMenu) {
        this.menuText = menuText;
        this.prevMenu = prevMenu;
    }

    public void print() {
        System.out.println("\n" + menuText); // 메뉴출력
    }

    public void setPrevMenu(Menu prevMenu) {
        this.prevMenu = prevMenu;
    }

}
