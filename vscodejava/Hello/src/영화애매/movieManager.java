package 영화애매;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import a0317.continue1;

public class movieManager {
    private static ArrayList<movieInfo> movies; // 영화 정보 저장
    private static ArrayList<human> humans; // 예약된 손님정보

    private static Map<String, movieInfo> reservationMap = new HashMap<>();
    private static movie mi = new movie(); // 파일 관련작업
    Scanner sc = new Scanner(System.in);

    public movieManager() {
        movies = new ArrayList<>();
        movies.add(new movieInfo("집에 가고싶다", "02:15", 11200, false));
        movies.add(new movieInfo("배고프다", "02:11", 10000, false));
        movies.add(new movieInfo("술 한잔해요", "02:11", 10000, true));
        humans = new ArrayList<>();
        reservationMap = new HashMap<>(); // reservationMap 초기화
    }

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
            "\n" +
            "                         TJOEUN Movie\n";

    // 영화 목록
    public void moiveList(String str) {
        System.out.println("===============" + str + "==============\n");
        int count = 1;
        for (movieInfo movie : movies) {
            System.out.println("================== " + count + " 번" + "===================\n" + movie);
            count++;
        }
        System.out.println("==========================================");
        System.out.println();
    }

    // 영화 예약
    public void reservation() throws InterruptedException {
        for (;;) { // 조건없는 무한루프문
            moiveList("영화 예매");
            System.out.print("예매할 영화 번호 입력해주세요 : ");
            try {
                int movieNum = Integer.parseInt(sc.next());
                if (movieNum > movies.size() || movieNum < 1) {
                    System.out.println("잘못된 번호입니다");
                    continue;
                }

                System.out.println("선택한 영화");
                System.out.println("==============================================================");
                System.out.println(
                        "================== " + movieNum + " 번" + "===================\n" + movies.get(movieNum - 1));
                System.out.println("==============================================================");
                movieInfo mf = movies.get(movieNum - 1);
                humanInfo(mf); // 예약 진행
                if (humans != null && !humans.isEmpty()) {
                    human p = humans.get(humans.size() - 1);

                    // 만 19세 미만이면 예약 취소
                    if (!p.age19() && mf.getAdultInfo()) {
                        System.out.println("만 19세 미만은 19세 영화 예약 불가입니다.");
                        humans.remove(humans.size() - 1); // 손님 정보 제거
                        continue; // 예약을 다시 시작하도록 함
                    } else {
                        // 좌석을 선택하고 예약을 진행
                        String seatNum = Integer.toString(setSelection(mf));
                        p.setSeat(seatNum); // 좌석 정보 설정
                        System.out.println("예약 중입니다.");
                        Thread.sleep(2000);
                        System.out.println("==============================================================");
                        System.out.println("예약에 성공했습니다.");
                        System.out.println("[" + humans.get(humans.size() - 1).getName() + "] 님의 예약 정보");
                        System.out.println();
                        reservationMap.put(humans.get(humans.size() - 1).getName(), mf);
                        System.out.println("================== " + movieNum + " 번" + "===================\n" + mf);
                        System.out.println("==============================================================");
                        System.out.println("잠시 후 메인 화면으로 이동합니다.");
                        Thread.sleep(2000);
                        System.out.println();
                        break; // 예약 후 종료하고 메인 메뉴로 돌아가도록
                    }
                }

            } catch (Exception e) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }
        }
    }

    // 좌석선택
    private int setSelection(movieInfo mf) {
        int seatNum = -1;
        while (true) {
            try {
                System.out.println("==============================================================");
                mf.seatToString();
                System.out.println();
                System.out.print("좌석번호를 선택해주세요 : ");
                int seatInt = sc.nextInt() - 1;
                sc.nextLine();
                if (seatInt + 1 < 1 || seatInt + 1 > 48) {
                    System.out.println("존재하지 않는 좌석입니다.");
                } else if (mf.getSeats().get(seatInt).equals("XX")) {
                    System.out.println("이미 예약된 자석입니다.");
                } else {
                    mf.getSeats().set(seatInt, "XX");
                    System.out.println("좌석 선택이 완료되었습니다");
                    seatNum = seatInt;
                    break;
                }
                System.out.println("==============================================================");
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다");
                sc.nextLine();
                continue;
            }
        }
        return seatNum;
    }

    // 예약자 및 19세 확인
    private void humanInfo(movieInfo mf) {
        System.out.println("예약자 정보를 입력하세요");
        System.out.print("이름 : ");
        String name = sc.next();

        String birthDatestr = "";
        boolean validBirthDate = false;
        while (!validBirthDate) {
            System.out.print("생년월일(6자리) : ");
            birthDatestr = sc.next();

            // 생년월일이 6자리 숫자인지 확인
            if (birthDatestr.length() == 6 && birthDatestr.matches("\\d{6}")) {
                validBirthDate = true;
            } else {
                System.out.println("생년월일은 6자리 숫자여야 합니다 EX) 010101");
            }
        }

        try {
            int birthDate = Integer.parseInt(birthDatestr);
            human p = new human(name, birthDate);

            // 만 19세 미만 / 19영화 예약 불가
            if (!p.age19() && mf.getAdultInfo()) {
                System.out.println("만 19세 미만은 성인영화 예약 불가입니다.");
            } else {
                System.out.print("결제 비밀번호 : ");
                String pw = sc.next();
                p = new human(name, birthDate, pw);
                humans.add(p); // 예약 명단에 손님 추가
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 생년월일을 숫자 6자리로 입력해주세요.");
        }

    }

    public void cancleReservation(movieManager movieManager, String name) {
        // 예약된 손님을 검색
        int index = movieManager.search("예약확인");

        if (index != -1) {
            // 비밀번호 확인
            movieManager.checkpassword(index);

            // 예약된 고객 정보 가져오기
            human canceledPassenger = movieManager.humans.get(index);
            String humanName = canceledPassenger.getName();

            // 예약 정보 삭제 전에 좌석 초기화
            movieInfo canceledMovie = movieManager.reservationMap.get(humanName);

            if (canceledMovie != null && canceledMovie.getSeats() != null) {
                // 좌석 번호가 유효한지 체크
                String seatStr = canceledPassenger.getSeat();
                if (seatStr != null && !seatStr.isEmpty()) {
                    try {
                        // 좌석 번호가 유효한 범위 내에 있는지 확인
                        int seatIndex = Integer.parseInt(seatStr);
                        if (seatIndex >= 0 && seatIndex < canceledMovie.getSeats().size()) {
                            // 좌석을 번호로 초기화 (취소된 좌석은 해당 번호로 표시)
                            canceledMovie.getSeats().set(seatIndex, String.format("%2d", seatIndex + 1));

                            // 좌석을 번호로 초기화한 후, 해당 좌석 번호를 표시하는 메서드 호출
                            System.out.println("좌석 " + (seatIndex + 1) + "이(가) 취소되어 예약 가능 상태로 돌아갔습니다.");
                        } else {
                            System.out.println("잘못된 좌석 번호입니다.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("좌석 번호가 유효하지 않습니다.");
                    }
                } else {
                    System.out.println("유효한 좌석 번호가 없습니다.");
                }
            } else {
                System.out.println("예약된 영화 정보나 좌석 정보가 없습니다.");
            }

            // 예약 정보 삭제
            movieManager.reservationMap.remove(humanName);

            // 고객 정보 삭제
            movieManager.humans.remove(index);

            // 좌석 상태를 업데이트하여 출력
            canceledMovie.seatToString(); // 좌석 상태 출력 메서드 호출
            System.out.println();
            System.out.println("[" + humanName + "]님의 예약이 취소되었습니다.");
            System.out.println();
        } else {
            System.out.println("예약된 손님이 없습니다.");
            System.out.println();
        }
    }

    // 비밀번호
    void checkpassword(int index) {
        System.out.print("결제 비밀번호 : ");
        String num = sc.next();
        System.out.println();
        if (humans.get(index).getPw().equals(num)) {
            System.out.println("비밀번호가 일치합니다");
            System.out.println(ticketPrint(reservationMap, humans.get(index).getName()));
        } else {
            System.out.println("비밀번호가 일치하지 않습니다");
        }
    }

    // 티켓 출력
    String ticketPrint(Map<String, movieInfo> reservationMap, String name) {
        int index = -1;
        if (humans != null) {
            for (int i = 0; i < humans.size(); i++) {
                if (humans.get(i).getName().equals(name)) {
                    index = i;
                }
            }
        }
        if (index != -1) {
            int seat = Integer.parseInt(humans.get(index).getSeat()) + 1;
            return "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n\n" +
                    "    " + name + "님의 티켓정보" +
                    " | 좌석 : " + seat + "번\n" +
                    "==========================================\n" +
                    reservationMap.get(name) + "\n\n" +
                    "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ";
        } else {
            return "예약정보가 없습니다";
        }
    }

    // 예약자 검색
    int search(String str) {
        System.out.println("===================== " + str + " =====================");
        System.out.print("예약자 이름: ");
        String name = sc.next();
        sc.nextLine();
        int index = -1;
    
        // humans 리스트가 비어 있지 않고, 예약자가 있는지 확인
        if (humans != null && !humans.isEmpty()) {
            for (int i = 0; i < humans.size(); i++) {
                if (humans.get(i).getName().equals(name)) {
                    index = i;
                    break; // 예약자가 있으면 더 이상 반복하지 않음
                }
            }
        }
    
        // 유효한 인덱스 체크
        if (index == -1) {
            System.out.println("예약자가 없습니다. 다시 입력해주세요.");
            return search(str); // 재귀적으로 다시 이름을 검색
        }
    
        return index; // 예약자가 있으면 인덱스를 반환
    }
    

    // 예약 조회
    public void checkReservation(String string) {
        int index = search("예약확인");
        if (index != -1) {
            checkpassword(index);
        } else {
            System.out.println("예약된 손님이 없습니다.");
        }
    }

    public void ticketPrint(String string) {
        int index = search("티켓 저장");
        checkpassword(index);
        mi.ticketSaveFile(reservationMap, humans.get(index).getName());
    }

    // 영화 업데이트
    public static ArrayList<movieInfo> getmovies() {
        return movies;
    }

    public static Map<String, movieInfo> getReservationMap() {
        return reservationMap;
    }

    // 영화 목록을 보여줌
    public void seat(String string) {
        moiveList("영화 목록");
        System.out.print("좌석을 확인할 영화 번호를 입력하세요 : ");
        try {
            int movieNum = Integer.parseInt(sc.nextLine());
            if (movieNum > 0 && movieNum <= movies.size()) {
                movieInfo selectedMovie = movies.get(movieNum - 1);
                System.out.println(selectedMovie.getType() + "의 좌석 상태:");
                selectedMovie.seatToString(); // 해당 영화의 좌석 상태 출력
                System.out.println();
                System.out.println();
            } else {
                System.out.println("잘못된 번호입니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다.");
        }
    }

}
