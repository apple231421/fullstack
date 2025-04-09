package 렌트카;

import java.util.ArrayList;

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
                if(!CheckAdminPW()){// 관리자 비번 확인
                    System.out.println( ">> 비밀번호가 틀렸습니다.");
                    return this;
                }
                AdminMenu adminMenu = AdminMenu.getInstance();
                adminMenu.setPrevMenu(this) ;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'RentCarTicketPrint'");
    }

    private void ReturnCar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ReturnCar'");
    }

    private void CheckRent() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CheckRent'");
    }

    private void Rent() {
        try {
            ArrayList<Car> cars = Car.findAll();
            for(int i = 0; i<cars.size();i++){
                System.out.printf("%s\n",cars.get(i).toString());
            }
        System.out.println("렌트할 차량을 선택해주세요");
        String carIdStr = sc.nextLine();
        Car c = Car.findById(carIdStr);
        ArrayList<RentCar>rentCars =RentCar.findByCarId(carIdStr);
        Count counts = new Count(rentCars);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
