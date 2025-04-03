package 영화애매;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import a0402.javaair.Flight;
import a0402.javaair.Passenger;

public class movieManager {
    private static ArrayList<movieInfo> movies; // 영화 정보 저장
    static ArrayList<human> humans; // 예약된 승객정보

    static Map<String, movieInfo> reservationMap = new HashMap<>();
    static movie mi = new movie(); // 파일 관련작업
    Scanner sc = new Scanner(System.in);

    public movieManager() {
        movies = new ArrayList<>();
        movies.add(new movieInfo("지", "02:15", 11230, false));
        movies.add(new movieInfo("밥을먹자", "02:11", 10000, false));
        movies.add(new movieInfo("19세", "02:11", 10000, true));
        humans = new ArrayList<>();
        reservationMap = new HashMap<>(); // reservationMap 초기화
        movieInfo mf = movies.get(0);
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
            "               * * * * * * * * * * * * * * * *\n" +
            "               Movie Theater - Enjoy the Show!\n";

    // 영화 목록
    public void moiveList(String str) {
        System.out.println("==========================" + str + "==========================");
        int count = 1;
        for (movieInfo movie : movies) {
            System.out.println(count + " " + movie);
            count++;
        }
        System.out.println("==============================================================");
    }

    // 영화 예약
    // 영화 예약 메서드 수정
    public void reservation() throws InterruptedException {
        for (;;) {
            moiveList("영화 예매");
            System.out.println("예매할 영화 번호 입력해주세요");
            try {
                int movieNum = Integer.parseInt(sc.next());
                if (movieNum > movies.size() || movieNum < 1) {
                    System.out.println("잘못된 번호입니다");
                    continue;
                }

                System.out.println("선택한 영화");
                System.out.println("==============================================================");
                System.out.println(movieNum + " " + movies.get(movieNum - 1));
                System.out.println("==============================================================");
                movieInfo mf = movies.get(movieNum - 1);
                humanInfo(mf); // 예약 진행
                if (humans != null && !humans.isEmpty()) {
                    human p = humans.get(humans.size() - 1);

                    // 만 15세 미만이면 예약 취소
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
                        System.out.println(movieNum + " " + mf);
                        System.out.println("==============================================================");
                        System.out.println("잠시 후 메인 화면으로 이동합니다.");
                        Thread.sleep(2000);

                        // 예약 정보를 맵에 추가
                        break; // 예약 후 종료하고 메인 메뉴로 돌아가도록
                    }
                }

            } catch (Exception e) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }
        }
    }

    private int setSelection(movieInfo mf) {
        int seatNum = -1;
        while (true) {
            try {
                System.out.println("==============================================================");
                System.out.println("좌석번호를 선택해주세요");
                mf.seatToString();
                int seatInt = sc.nextInt() - 1;
                sc.nextLine();
                if (seatInt + 1 < 1 || seatInt + 1 > 64) {
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
            }
        }
        return seatNum;
    }

    private void humanInfo(movieInfo mf) {
        System.out.println("예약지 정보를 입력하세요");
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
                System.out.println("결제 비밀번호를 입력하세요");
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

            // 예약된 승객 정보 가져오기
            human canceledPassenger = movieManager.humans.get(index);
            String passengerName = canceledPassenger.getName();

            // 예약 정보 삭제
            movieManager.reservationMap.remove(passengerName);

            // 승객 정보 삭제
            movieManager.humans.remove(index);

            // 좌석 정보 초기화 (예약 취소된 승객의 좌석을 "o"로 초기화)
            movieInfo canceledMovie = movieManager.reservationMap.get(passengerName);

            if (canceledMovie != null && canceledMovie.getSeats() != null) {
                // 좌석을 "o"로 초기화
                int seatIndex = Integer.parseInt(canceledPassenger.getSeat()) - 1;
                canceledMovie.getSeats().set(seatIndex, "o"); // 좌석을 "o"로 초기화
                System.out.println("예약이 취소되었습니다.");
            } else {
                System.out.println("좌석 정보가 초기화되지 않았습니다.");
            }
        } else {
            System.out.println("예약된 손님이 없습니다.");
        }
    }

    // 예약 취소 처리
    // 예약 취소 처리
    private void cancelBooking(int index) {
        // 승객 이름을 가져옴
        String name = humans.get(index).getName();

        // 해당 승객의 예약 정보 삭제
        movieInfo mf = reservationMap.remove(name);

        // 예약 취소 후 좌석 정보 초기화
        if (mf != null) {
            // 좌석을 다시 "o"로 초기화
            int seatIndex = Integer.parseInt(humans.get(index).getSeat()) - 1; // 좌석 번호 1-based -> 0-based로 변환
            mf.getSeats().set(seatIndex, "o"); // 좌석을 "o"로 초기화하여 좌석을 다시 사용 가능하게 설정
            System.out.println("좌석이 다시 예약 가능 상태로 돌아갔습니다.");
        }

        // 승객 목록에서 해당 승객 정보 삭제
        humans.remove(index);

        // 예약 취소 완료 메시지
        System.out.println("[" + name + "]님의 예약이 취소되었습니다.");
    }

    void checkpassword(int index) {
        System.out.println("결제 비밀번호");
        String num = sc.next();
        System.out.println();
        if (humans.get(index).getPw().equals(num)) {
            System.out.println("비밀번호가 일치합니다");
            System.out.println(numprint(reservationMap, humans.get(index).getName()));
        } else {
            System.out.println("비밀번호가 일치하지 않습니다");
        }
    }

    String numprint(Map<String, movieInfo> reservationMap, String name) {
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
                    "\t" + name + "님의 티켓정보" +
                    "| 좌석 : " + seat + "번\n" +
                    "." + reservationMap.get(name) + "\n\n" +
                    "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ";
        } else {
            return "예약정보가 없습니다";
        }
    }

    int search(String str) {
        System.out.println("===================== " + str + " =====================");
        System.out.print("예약자 이름: ");
        String name = sc.next();
        sc.nextLine();
        int index = -1;
        if (humans != null) {
            for (int i = 0; i < humans.size(); i++) {
                if (humans.get(i).getName().equals(name)) {
                    index = i;
                }
            }
        }
        return index;
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

    // 영화 업데이트
    public static ArrayList<movieInfo> getmovies() {
        return movies;
    }

    public static Map<String, movieInfo> getReservationMap() {
        return reservationMap;
    }
}
