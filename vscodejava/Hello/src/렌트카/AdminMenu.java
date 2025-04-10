package 렌트카;

import java.io.IOException;
import java.util.ArrayList;

public class AdminMenu extends AbstractMenu {

    private static final AdminMenu instance = new AdminMenu(prevMenu);
    private static final String ADMIN_MENU_TEXT = // 기본 문구
            "1: 렌트카 등록하기\n" +
                    "2: 렌트카 목록 보기\n" +
                    "3: 렌트카 폐차하기\n" +
                    "4: 렌트카 현황보기\n" +
                    "5: 메인 메뉴로 이동\n\n" +
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
                RentCarStatus();
                return this;
            case "5":
                return prevMenu;
            default:
                return this;
        }
    }

    private void RentCarStatus() {
        try {
            // 전체 차량 목록 가져오기
            ArrayList<Car> cars = Car.findAll();
            if (cars == null || cars.isEmpty()) {
                System.out.println(">> 등록된 차량이 없습니다.");
                return;
            }

            System.out.println("\n====================================");
            System.out.println("         렌트카 현황 조회           ");
            System.out.println("====================================");
            System.out.printf("%-5s %-15s %-10s%n", "번호", "차량명", "현황");
            System.out.println("------------------------------------");

            // 각 차량별 현황 출력
            for (Car car : cars) {
                try {
                    // 해당 차량의 대여 정보 확인
                    ArrayList<RentCar> rentCars = RentCar.findByCarId(car.getId() + ""); // 문자열로 명시적 변환

                    // rentCars가 null인 경우 새 ArrayList 생성
                    if (rentCars == null) {
                        rentCars = new ArrayList<>();
                    }

                    Count count = new Count(rentCars);
                    int available = count.getAvailableCount();

                    // 차량 정보 출력
                    System.out.printf("%-5d %-15s %-10s%n",
                            car.getId(),
                            car.getName(),
                            "대여가능: " + available + "대");

                } catch (Exception ex) {
                    System.out.println(">> 차량 정보 조회 중 오류가 발생했습니다: " + ex.getMessage());
                }
            }

            System.out.println("====================================");
            System.out.println("         조회가 완료되었습니다     ");
            System.out.println("====================================\n");

        } catch (IOException e) {
            System.out.println(">> 파일 처리 중 오류가 발생했습니다: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(">> 시스템 오류가 발생했습니다: " + e.getMessage());
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

            // 데이터가 비어있는 경우 처리
            if (cars.isEmpty()) {
                System.out.println("등록된 차량이 없습니다.");
                return;
            }

            System.out.println("\n=== 등록된 차량 목록 ===");
            for (Car car : cars) { // 향상된 for문 사용
                System.out.println(car.toString());
            }
            System.out.println("=====================");

        } catch (IOException e) {
            System.out.println("데이터 접근에 실패했습니다: " + e.getMessage());
            e.printStackTrace(); // 디버깅을 위한 스택 트레이스 출력
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
