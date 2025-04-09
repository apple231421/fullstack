package 렌트카;

import java.io.IOException;
import java.util.ArrayList;

import a1206.movie.Movie;

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
        printAllRentCar();
        System.out.println("폐차할 자동차를 선택하세요");
        try {
            Car.delete(sc.nextLine());
        } catch (IOException e) {
            System.out.println(">>폐차 실패");
        }
    }

    private void printAllRentCar() {
        try {
            ArrayList<Car> cars = Car.findAll();
            System.out.println();
            for (int i = 0; i < cars.size(); i++) {
                System.out.printf("%s\n", cars.get(i).toString());
            }
        } catch (IOException e) {
            System.out.println("데이터 접근에 실패"); // 예회처리
        }
    }

    private void addRentCar() {
        System.out.println("차량 이름 : ");
        String name = sc.nextLine();
        System.out.println("차량 종류 : ");
        String genre = sc.nextLine();
        Car car = new Car(name, genre);
        try {
            car.save();
        } catch (IOException e) {
            System.out.println(">> 실패하였습니다.");
        }
    }
}
