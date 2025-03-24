package a0324.숙소;

import java.util.Scanner;

public class search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        hotelmanager manager = new hotelmanager();
        boolean flag = true;
        while (flag) {
            System.out.println("\n숙소 예약 시스템에 오신 것을 환영합니다.");
            System.out.println("1. 예약 가능한 숙소 보기");
            System.out.println("2. 숙소 예약하기");
            System.out.println("3. 예약한 숙소 보기");
            System.out.println("4. 숙소 추가하기");
            System.out.println("5. 숙소 삭제하기");
            System.out.println("6. 숙소 정보 수정하기");
            System.out.println("7. 숙소 정보 조회하기");
            System.out.println("8. 종료");
            System.out.print("원하는 작업을 선택하세요 > ");
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    System.out.println("예약 가능한 숙소 보기");
                    manager.allhotel();
                    break;
                case 2:
                    System.out.println("숙소 예약하기");
                    System.out.println("숙박예약하려는 호텔의 이름을 입력하세요");
                    String hotelname = sc.nextLine();
                    if(manager.hotellocations(hotelname)){
                        System.out.println("숙박예약이 성공적으로 되었습니다");
                    }else{
                        System.out.println("숙박예약이 불가능하거나 존재하지 않는 숙박명입니다");
                    }
                    break;
                case 3:
                    System.out.println("예약한 숙소 보기");
                    manager.hotellocation();
                    break;
                case 4:
                    System.out.println("숙소 추가하기");
                    System.out.print("예약할 숙소 이름 : ");
                    String newname= sc.nextLine();
                    System.out.print("예약할 숙소 지역 : ");
                    String newlocation= sc.nextLine();
                    System.out.print("숙소 가격 : ");
                    Double newprice= sc.nextDouble();
                    manager.addagoda(newname,newlocation,newprice);
                    System.out.println("예약 완료");
                    break;
                case 5:
                    System.out.println("숙소 삭제하기");
                    break;
                case 6:
                    System.out.println("숙소 정보 수정하기");
                    break;
                case 7:
                    System.out.println("숙소 정보 조회하기");
                    break;
                case 8:
                    System.out.println("종료");
                    break;

                default:
                    break;
            }
        }
    }
}
