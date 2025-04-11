package 렌트카;

import java.io.IOException;
import java.util.ArrayList;

// 메인 메뉴 클래스: 사용자 기능(렌트, 반납 등) 처리
class MainMenu extends AbstractMenu {

    // 싱글톤 인스턴스 생성
    private static final MainMenu instance = new MainMenu(null);

    // 싱글톤 접근 메서드
    public static MainMenu getInstance() {
        return instance;
    }

    // 메인 메뉴 출력 텍스트
    private static final String MAIN_MENU_TEXT = "1. 렌트카 대여하기\n" +
            "2. 렌트카 대여확인하기\n" +
            "3. 렌트카 반납하기\n" +
            "4. 렌트카 대여 확인증 발급하기\n" +
            "5. 관리자 모드\n" +
            "0. 종료\n";

    // 생성자
    public MainMenu(Menu prevMenu) {
        super(MAIN_MENU_TEXT, prevMenu);
    }

    // 사용자 입력에 따라 다음 동작을 결정
    @Override
    public Menu next() {
        switch (sc.nextLine()) {
            case "1":
                Rent(); // 차량 대여
                return this;
            case "2":
                checkRent(); // 대여 현황 확인
                return this;
            case "3":
                ReturnCar(); // 차량 반납
                return this;
            case "4":
                RentCarTicketPrint(); // 대여 티켓 출력
                return this;
            case "5":
                if (!CheckAdminPW()) { // 관리자 모드 진입
                    System.out.println(">> 비밀번호가 틀렸습니다.");
                    return this;
                }
                AdminMenu adminMenu = AdminMenu.getInstance();
                adminMenu.setPrevMenu(this);
                return adminMenu;
            case "0":
                return null; // 프로그램 종료
            default:
                return this; // 잘못된 입력은 현재 메뉴 유지
        }
    }

    // 관리자 비밀번호 검증 (현재는 고정값 apple)
    private boolean CheckAdminPW() {
        System.out.print("관리자 비밀번호를 입력하세요 : ");
        return "apple".equals(sc.nextLine());
    }

    // 대여 확인증 발급
    private void RentCarTicketPrint() {
        try {
            System.out.println("\n=== 렌트카 티켓 조회 ===");
            System.out.print("조회할 발급 번호를 입력하세요: ");
            String rentIdStr = sc.nextLine();

            RentCar rentCar = RentCar.findByRentId(rentIdStr);
            if (rentCar == null) {
                System.out.println(">> 해당하는 렌트 번호를 찾을 수 없습니다.");
                return;
            }

            // 티켓 출력 형식
            System.out.println("\n==========================================");
            System.out.println("           렌트카 이용 티켓             ");
            System.out.println("==========================================");
            System.out.println("발급번호: " + rentCar.getId());
            System.out.println("차량ID: " + rentCar.getCarId());
            System.out.println("차종: " + rentCar.getCarName());
            System.out.println("대여 수량: " + rentCar.getCarcount() + "대");
            System.out.println("상태: " + (rentCar.isReturned() ? "반납완료" : "대여중"));
            System.out.println("==========================================");
            System.out.println("    이용해 주셔서 감사합니다.");
            System.out.println("==========================================\n");

        } catch (IOException e) {
            System.out.println(">> 파일 처리 중 오류가 발생했습니다: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(">> 티켓 조회 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 차량 반납 기능
    private void ReturnCar() {
        try {
            System.out.println("\n=== 렌트카 반납 ===");
            System.out.print("반납할 차량의 발급 번호를 입력하세요: ");
            String rentIdStr = sc.nextLine();

            RentCar rentCar = RentCar.findByRentId(rentIdStr);
            if (rentCar == null) {
                System.out.println(">> 해당하는 차량의 발급 번호를 찾을 수 없습니다.");
                return;
            }

            ArrayList<RentCar> allRentCars = RentCar.findByCarId(String.valueOf(rentCar.getCarId()));
            Count count = new Count(allRentCars);

            int returnCount = Integer.parseInt(rentCar.getCarcount());

            // 반납 처리
            count.returnCar(returnCount);
            rentCar.markAsReturned();

            System.out.println("\n=== 반납이 완료되었습니다 ===");
            System.out.println("차량명: " + rentCar.getCarName());
            System.out.println("반납 수량: " + returnCount);
            count.show(); // 현황 출력

        } catch (IOException e) {
            System.out.println(">> 파일 처리 중 오류가 발생했습니다: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(">> 수량 정보 처리 중 오류가 발생했습니다.");
        } catch (Exception e) {
            System.out.println(">> 반납 처리 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 대여 현황 확인
    private void checkRent() {
        System.out.println("\n=== 차량 대여 현황 확인 ===");
        System.out.print("차량 ID를 입력해주세요: ");
        String carId = sc.nextLine().trim();

        if (carId.isEmpty()) {
            System.out.println(">> 차량 ID를 반드시 입력해주세요.");
            return;
        }

        try {
            Car car = Car.findById(carId);
            if (car == null) {
                System.out.println(">> 존재하지 않는 차량 ID입니다.");
                return;
            }

            ArrayList<RentCar> rentCars = RentCar.findByCarId(carId);
            Count count = new Count(rentCars);

            // 현황 출력
            System.out.println("\n=== 차량 대여 현황 ===");
            System.out.println("차량 ID: " + car.getId());
            System.out.println("차량 이름: " + car.getName());
            System.out.println("현재 대여중: " + count.getRentedCount() + "대");
            System.out.println("대여 가능: " + count.getAvailableCount() + "대");
            System.out.println("===================");

            // 현재 대여 중인 목록 출력
            if (!rentCars.isEmpty()) {
                System.out.println("\n=== 현재 대여 중인 내역 ===");
                for (RentCar rentCar : rentCars) {
                    if (!rentCar.isReturned()) {
                        System.out.printf("발급번호: %s, 대여수량: %s대%n",
                                rentCar.getId(),
                                rentCar.getCarcount());
                    }
                }
                System.out.println("===================");
            }

        } catch (IOException e) {
            System.out.println(">> 정보 조회 중 파일 처리 오류가 발생했습니다.");
        } catch (Exception e) {
            System.out.println(">> 시스템 오류가 발생했습니다.");
        }
    }

    // 차량 렌트 기능
    private void Rent() {
        try {
            ArrayList<Car> cars = Car.findAll();
            if (cars.isEmpty()) {
                System.out.println("\n>> 등록된 차량이 없습니다.");
                System.out.println("관리자한테 문의해주세요");
                return;
            }

            // 차량 목록 출력
            for (Car car : cars) {
                System.out.println(car.toString());
            }

            System.out.print("렌트할 차량의 ID를 입력해주세요: ");
            String carIdStr = sc.nextLine();

            Car selectedCar = Car.findById(carIdStr);
            if (selectedCar == null) {
                System.out.println(">> 존재하지 않는 차량입니다.");
                return;
            }

            ArrayList<RentCar> rentCars = RentCar.findByCarId(carIdStr);
            Count count = new Count(rentCars);
            count.show(); // 재고 현황 출력

            System.out.print("대여할 수량을 입력하세요 : ");
            int rentCount = Integer.parseInt(sc.nextLine());

            if (rentCount <= 0) {
                System.out.println(">> 수량은 1 이상이어야 합니다.");
                return;
            }

            if (count.isAvailable(rentCount)) {
                count.markRented(rentCount);

                RentCar newRent = new RentCar(
                        Long.parseLong(carIdStr),
                        selectedCar.getName(),
                        String.valueOf(rentCount));
                newRent.save();

                System.out.println(">> 렌트가 완료되었습니다");
                System.out.printf(">> 렌트번호: %d\n", newRent.getId());

                count.show(); // 최신 재고 출력
            } else {
                System.out.println(">> 대여 가능한 수량을 초과하였습니다.");
            }

        } catch (NumberFormatException e) {
            System.out.println(">> 올바른 숫자를 입력해주세요.");
        } catch (IOException e) {
            System.out.printf(">> 파일 처리 중 오류가 발생했습니다: %s\n", e.getMessage());
        } catch (Exception e) {
            System.out.printf(">> 렌트 처리 중 오류가 발생했습니다: %s\n", e.getMessage());
        }
    }

}
