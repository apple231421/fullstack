package 렌트카;

import java.io.IOException;
import java.util.ArrayList;

// 관리자 메뉴 클래스 (렌트카 등록/목록/폐차/현황 등 제공)
public class AdminMenu extends AbstractMenu {
    // 생성자: 메뉴 텍스트와 이전 메뉴 설정
    public AdminMenu(Menu prevMenu) {
        super(ADMIN_MENU_TEXT, prevMenu);
    }

    // 싱글톤 인스턴스 반환
    public static AdminMenu getInstance() {
        return instance;
    }

    // 싱글톤 패턴 적용: 하나의 AdminMenu 인스턴스만 사용
    private static final AdminMenu instance = new AdminMenu(prevMenu);

    // 출력할 관리자 메뉴 텍스트
    private static final String ADMIN_MENU_TEXT = "1: 렌트카 등록하기\n" +
            "2: 렌트카 목록 보기\n" +
            "3: 렌트카 폐차하기\n" +
            "4: 렌트카 현황보기\n" +
            "5: 메인 메뉴로 이동\n";

    // 사용자 입력에 따라 다음 메뉴 또는 기능 실행
    @Override
    public Menu next() {
        switch (sc.nextLine()) {
            case "1":
                addRentCar(); // 렌트카 등록
                return this;
            case "2":
                printAllRentCar(); // 렌트카 목록 출력
                return this;
            case "3":
                deleteCar(); // 렌트카 폐차
                return this;
            case "4":
                RentCarStatus(); // 렌트카 현황 보기
                return this;
            case "5":
                return prevMenu; // 메인 메뉴로 이동
            default:
                return this; // 잘못된 입력 시 현재 메뉴 유지
        }
    }

    // 렌트카 현황 출력 (총수량, 대여중, 대여가능)
    private void RentCarStatus() {
        try {
            ArrayList<Car> cars = Car.findAll();
            if (cars == null || cars.isEmpty()) {
                System.out.println(">> 등록된 차량이 없습니다.");
                return;
            }

            // 현황 헤더 출력
            System.out.println("=================================================");
            System.out.println("                렌트카 현황 조회                  ");
            System.out.println("=================================================");
            System.out.printf("%-12s %-15s%n", "차량ID", "차종");
            System.out.println("-------------------------------------------------");

            // 각 차량별 현황 출력
            for (Car car : cars) {
                try {
                    ArrayList<RentCar> rentCars = RentCar.findByCarId(car.getId());
                    Count count = new Count(rentCars);

                    System.out.printf("%-12s %-10s 총수량:%-2d  대여중 : %-2d    대여가능: %-2d%n",
                            car.getId(),
                            car.getName(),
                            count.getTotalCount(),
                            count.getRentedCount(),
                            count.getAvailableCount());

                } catch (Exception ex) {
                    System.out.println(">> 차량 정보 출력 중 오류가 발생했습니다.");
                }
            }

            System.out.println("=================================================");

        } catch (IOException e) {
            System.out.println(">> 파일 처리 중 오류가 발생했습니다.");
        } catch (Exception e) {
            System.out.println(">> 시스템 오류가 발생했습니다.");
        }
    }

    

    // 차량 폐차 처리
    private void deleteCar() {
        try {
            if (!printAllRentCar()) {
                return; // 차량이 없으면 메뉴로 나감
            }

            System.out.print("폐차할 차량ID를 입력하세요 : ");
            String carId = sc.nextLine();

            Car car = Car.findById(carId);
            if (car == null) {
                System.out.println(">> 해당 차량ID를 찾을 수 없습니다.");
                return;
            }

            Car.delete(carId);
            System.out.println(car.getName() + " 차량이 폐차되었습니다.");

        } catch (IOException e) {
            System.out.println(">> 폐차 실패: 파일 처리 오류");
        } catch (Exception e) {
            System.out.println(">> 폐차 실패: 시스템 오류");
        }
    }

    // 등록된 차량 목록 출력
    private boolean printAllRentCar() {
        try {
            ArrayList<Car> cars = Car.findAll();
            if (cars.isEmpty()) {
                System.out.println(">> 등록된 차량이 없습니다. 메뉴로 돌아갑니다.");
                return false;
            }

            System.out.println("\n=== 등록된 차량 목록 ===");
            for (Car car : cars) {
                System.out.println(car.toString());
            }
            System.out.println("=====================");
            return true;

        } catch (IOException e) {
            System.out.println("데이터 접근에 실패했습니다: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // 렌트카 등록
    private void addRentCar() {
        System.out.print("차량 이름 : ");
        String name = sc.nextLine();
        System.out.print("차량 종류 : ");
        String genre = sc.nextLine();
        Car car = new Car(name, genre);
        try {
            car.save();
        } catch (IOException e) {
            System.out.println(">> 실패하였습니다.");
        }
    }
}
