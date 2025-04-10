package 렌트카;

import java.io.IOException;
import java.util.ArrayList;

import a0324.book1.library;
import a1206.movie.Reservation;

class MainMenu extends AbstractMenu {

    private static final MainMenu instance = new MainMenu(null);

    public static MainMenu getInstance() {
        return instance;
    }

    private static final String MAIN_MENU_TEXT = "1. 렌트카 대여하기 \n" +
            "2. 렌트카 대여확인하기 \n" +
            "3. 렌트카 반납하기 \n" +
            "4. 렌트카 대여 확인증 발급하기 \n" +
            "5. 관리자 모드 \n" +
            "0. 종료";

    public MainMenu(Menu prevMenu) {
        super(MAIN_MENU_TEXT, prevMenu); // 부모의 생성자를 호출
    }

    @Override
    public Menu next() {
        switch (sc.nextLine()) {
            case "1":
                Rent(); // 렌트 진행
                return this;
            case "2":
                CheckRent(); // 렌트카 대여 확인
                return this;
            case "3":
                ReturnCar(); // 렌트카 반납
                return this;
            case "4":
                RentCarTicketPrint(); // 렌트카 대여 확인증 발급
                return this;
            case "5":
                if (!CheckAdminPW()) {// 관리자 비번 확인
                    System.out.println(">> 비밀번호가 틀렸습니다.");
                    return this;
                }
                AdminMenu adminMenu = AdminMenu.getInstance();
                adminMenu.setPrevMenu(this);
                return adminMenu;
            case "0":
                return null;
            default:
                return this;
        }
    }

    private boolean CheckAdminPW() {
        System.out.println("관리자 비밀번호를 입력하세요");
        return "apple".equals(sc.nextLine());
    }

    private void RentCarTicketPrint() {
        try {
            System.out.println("\n=== 렌트카 티켓 조회 ===");
            System.out.print("조회할 렌트 번호를 입력하세요: ");
            String rentIdStr = sc.nextLine();

            // 렌트 정보 검색
            RentCar rentCar = RentCar.findByRentId(rentIdStr);
            if (rentCar == null) {
                System.out.println(">> 해당하는 렌트 번호를 찾을 수 없습니다.");
                return;
            }

            // 티켓 출력
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

    private void ReturnCar() {
        try {
            System.out.println("\n=== 렌트카 반납 ===");
            System.out.print("반납할 렌트 번호를 입력하세요: ");
            String rentIdStr = sc.nextLine();

            // 렌트 정보 검색
            RentCar rentCar = RentCar.findByRentId(rentIdStr);
            if (rentCar == null) {
                System.out.println(">> 해당하는 렌트 번호를 찾을 수 없습니다.");
                return;
            }

            // 현재 대여 현황 확인
            ArrayList<RentCar> allRentCars = RentCar.findByCarId(String.valueOf(rentCar.getCarId()));
            Count count = new Count(allRentCars);

            // 반납할 수량 가져오기
            int returnCount = Integer.parseInt(rentCar.getCarcount());

            // 수량 업데이트 및 반납 처리
            count.returnCar(returnCount);
            rentCar.markAsReturned();

            System.out.println("\n=== 반납이 완료되었습니다 ===");
            System.out.println("차량명: " + rentCar.getCarName());
            System.out.println("반납 수량: " + returnCount);

            // 갱신된 현황 표시
            count.show();

        } catch (IOException e) {
            System.out.println(">> 파일 처리 중 오류가 발생했습니다: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(">> 수량 정보 처리 중 오류가 발생했습니다.");
        } catch (Exception e) {
            System.out.println(">> 반납 처리 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private void CheckRent() {
        System.out.println("발급번호를 입력하세요");
        try {
            Reservation r = Reservation.findById(sc.nextLine());
            if (r != null) {
                System.out.printf(">>[확인완료] %s \n", r.toString());
            } else {
                System.out.println("예매내역없음");
            }
        } catch (Exception e) {
            System.out.println("파일입출력에 문제가 발생");
        }
    }

    private void Rent() {
        try {
            // 전체 차량 목록 표시
            ArrayList<Car> cars = Car.findAll();
            if (cars.isEmpty()) {
                System.out.println(">> 등록된 차량이 없습니다.");
                return;
            }

            // 차량 목록 출력
            for (Car car : cars) {
                System.out.println(car.toString());
            }

            // 차량 선택
            System.out.println("렌트할 차량의 ID를 입력해주세요: ");
            String carIdStr = sc.nextLine();

            // 선택한 차량 정보 확인
            Car selectedCar = Car.findById(carIdStr);
            if (selectedCar == null) {
                System.out.println(">> 존재하지 않는 차량입니다.");
                return;
            }

            // 해당 차량의 대여 현황 확인
            ArrayList<RentCar> rentCars = RentCar.findByCarId(carIdStr);
            Count count = new Count(rentCars);

            // 현재 대여 현황 표시
            count.show();

            // 대여 수량 입력
            System.out.println("대여할 수량을 입력하세요: ");
            int rentCount = Integer.parseInt(sc.nextLine());

            // 대여 가능 여부 확인 및 처리
            if (count.isAvailable(rentCount)) {
                count.markRented(rentCount);

                // 새로운 렌트카 정보 저장
                RentCar newRent = new RentCar(
                        Long.parseLong(carIdStr),
                        selectedCar.getName(),
                        String.valueOf(rentCount));
                newRent.save();

                System.out.println(">> 렌트가 완료되었습니다");
                System.out.printf(">> 렌트번호: %d\n", newRent.getId());

                // 갱신된 현황 표시
                count.show();
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
