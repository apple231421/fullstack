package 영화애매;

import java.util.Scanner;

public class movieMain {
    public static void main(String[] args) {
        movieManager mm = new movieManager();
        Scanner sc = new Scanner(System.in);
        System.out.println(mm.movieLogo);
        movie mf = new movie();
        System.out.println("============== 더조은영화관에 오신걸 환영합니다. ==============\n");

        Outter: while (true) {
            System.out.println("1. 상영영화 목록\n2. 영화 예매\n3. 예약 취소\n4. 예약 조회\n5. 티켓 발행\n6. 영화목록업데이트\n0. 종료");
            System.out.println("메뉴입력> ");

            String menustr = sc.next();
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
                    mm.cancleReservation(mm, "예약 취소");

                    break;
                case 4:// 예약 조회
                    mm.checkReservation("예약 조회");
                    break;
                case 5:// 티켓 발행
                    // mm.ticketPrint(null, "티켓 발행");
                    break;
                case 6:// 티켓 발행
                    mf.update("영화목록 업데이트");
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다");
                    sc.close();
                    break Outter;
                default:
                    break;
            }
        }
    }

}
