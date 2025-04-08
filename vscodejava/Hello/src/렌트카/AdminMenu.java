package 렌트카;

public class AdminMenu extends AbstractMenu {

    private static final AdminMenu instance = new AdminMenu(prevMenu);
    private static final String ADMIN_MENU_TEXT = // 기본 문구
            "1: 렌트카 등록하기\n" +
                    "2: 렌트카 목록 보기\n" +
                    "3: 렌트카 폐차하기\n" +
                    "4: 메인 메뉴로 이동\n\n" +
                    "메뉴를 선택하세요: ";

    public AdminMenu(Menu prevMenu) {
        super(ADMIN_MENU_TEXT, prevMenu);

    }

    public static AdminMenu getInstance() {
        return instance;
    }

    @Override
    public Menu next() {
        switch (sc.nextLine()) {
            case "1":
                addRentCar(); // 렌트카 추가
                return this;
            case "2":
                printAllRentCar(); // 렌트카 목록보기
                return this;
            case "3":
                deleteCar(); // 폐차
                return this;
            case "4":
                return prevMenu;
            default:
                return this;
        }
    }

    private void deleteCar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCar'");
    }

    private void printAllRentCar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printAllRentCar'");
    }

    private void addRentCar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addRentCar'");
    }
}
