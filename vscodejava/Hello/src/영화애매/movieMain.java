package 영화애매;

import java.util.Scanner;

public class movieMain {
    public static void main(String[] args) {
        moiveManager mm = new moiveManager();
        Scanner sc = new Scanner(System.in);
        System.out.println(mm.movieLogo);
        System.out.println("============== 더조은영화관에 오신걸 환영합니다. ==============\n");

        Outter: while (true) {
            System.out.println("1. 상영영화 목록\n2. 영화 예매\n3. 예약 조회\n4. 예약 취소\n5. 티켓 발행\n\n0. 종료");
            System.out.println("메뉴입력> ");

            String menustr = sc.nextLine();
            sc.nextLine();

            int menu = -1;
            try {
                menu = Integer.parseInt(menustr);
            } catch (NumberFormatException e) {
                menu = 9;
            }
            switch (menu) {
                case 1:// 상영영화 목록
                    mm.moiveList("상영영화 목록");
                    break;
                case 2: // 영화 예매
                    try {
                        mm.reservation();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:// 예약 취소
                    mm.cancleReservation("예약 취소");

                    break;
                case 4:// 예약 조회
                    mm.checkReservation("예약 조회");
                    break;
                case 5:// 티켓 발행
                    mm.ticketPrint("티켓 발행");
                    break;
                default:
                    break;
            }
        }
    }

}
