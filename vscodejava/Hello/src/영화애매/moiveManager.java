package 영화애매;

import java.util.ArrayList;

public class moiveManager {
    private static ArrayList<movie> movies;// 영화 정보 저장
    private static ArrayList<human> humans;// 영화 정보 저장


    public String movieLogo = "                  ___________________________\n" +
            "                 |                           |\n" +
            "                 |           SCREEN          |\n" +
            "                 |___________________________|\n" +
            "        _________|___________________________|_________\n" +
            "       |                                               |\n" +
            "       |                                               |\n" +
            "       |   o   o       o   o   o   o   o       o   o   |\n" +
            "       |   o   o       o   o   o   o   o       o   o   |\n" +
            "       |   o   o       o   o   o   o   o       o   o   |\n" +
            "       |   o   o       o   o   o   o   o       o   o   |\n" +
            "       |   o   o       o   o   o   o   o       o   o   |\n" +
            "       |   o   o       o   o   o   o   o       o   o   |\n" +
            "       |   o   o       o   o   o   o   o       o   o   |\n" +
            "       |                                               |\n" +
            "       |_______________________________________________|\n" +
            "               * * * * * * * * * * * * * * * *\n" +
            "               Movie Theater - Enjoy the Show!\n";

    public moiveManager() {
        movies= new ArrayList<>();
    
    }

    // 영화 목록
    public void moiveList(String string) {

    }

    // 영화 예약
    public void reservation() throws InterruptedException {

    }

    // 예약 취소
    public void cancleReservation(String string) {

    }

    // 예약 조회
    public void checkReservation(String string) {

    }

    // 티켓 발행
    public void ticketPrint(String string) {

    }

}
