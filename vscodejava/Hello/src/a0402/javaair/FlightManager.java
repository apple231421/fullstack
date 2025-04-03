package a0402.javaair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class FlightManager {
    private static ArrayList<Flight> flights; // 항공편 정보를 저장 ArrayList
    private static ArrayList<Passenger> passengers; // 예약된 승객정보

    // 승객을 키로하고, 예약된 항공편을 값으로 가지는 Map
    private static Map<String, Flight> reservationMap = new HashMap<>();

    private static Filec fc = new Filec(); // 파일 관련작업
    Scanner sc = new Scanner(System.in);

    public FlightManager() {
        flights = new ArrayList<>();
        flights.add(new Flight("제주", "11:55", 380000, false));
        flights.add(new Flight("이스탄불", "17:10", 1200000, true));
        flights.add(new Flight("방콕", "21:35", 480000, true));
        passengers = new ArrayList<>();
        Flight sf = flights.get(0);
    }

    public String airplane = "                       |                      \n"
            + "                      _|_                     \n" + "                    /_____\\                  \n"
            + "                   /oo   oo\\                 \n"
            + " \\_________________\\       /_________________/\n"
            + "  `-------|---|-----\\_____/-----|---|-------'\n" + "         ( ) ( )  O|OOo|oOO|O  ( ) ( )   \n";

    
        public void displayFlightList(String str) {
        System.out.println("==========================" + str + "==========================");
        int count = 1;
        for (Flight flight : flights) {
            System.out.println(count + " " + flight);
            count++;
        }
        System.out.println("==============================================================");
    }

    // 항공편 예약
    public void bookFlight() throws InterruptedException {
        for (;;) {
            displayFlightList("항공편 예매");
            System.out.print("예매할 항공편 번호 입력 > ");
            try {
                int bookNum = Integer.parseInt(sc.next());
                if (bookNum > flights.size() || bookNum < 1) {
                    System.out.println("잘못된 입력입니다.");
                    continue;
                }
                System.out.println("선택한 항공편");
                System.out.println("==============================================================");
                System.out.println(bookNum + " " + flights.get(bookNum - 1));
                System.out.println("==============================================================");
                Flight sf = flights.get(bookNum - 1);
                passengerInfo(sf);

                // 승객이 등록되었고, 만약 승객이 국제선 예약을 시도하는데 15세 미만이라면 예약을 진행하지 않음
                if (passengers != null && !passengers.isEmpty()) {
                    Passenger p = passengers.get(passengers.size() - 1);

                    // 만 15세 미만이면 예약 취소
                    if (!p.man15() && sf.getInternationalFlight()) {
                        System.out.println("만 15세 미만은 국제선 예약 불가입니다.");
                        passengers.remove(passengers.size() - 1); // 승객 정보 제거
                        continue; // 예약을 다시 시작하도록 함
                    } else {
                        // 좌석을 선택하고 예약을 진행
                        String seatNum = Integer.toString(setSelection(sf));
                        p.setSeat(seatNum); // 좌석 정보 설정
                        System.out.println("예약 중입니다.");
                        Thread.sleep(2000);
                        System.out.println("==============================================================");
                        System.out.println("예약에 성공했습니다.");
                        System.out.println("[" + passengers.get(passengers.size() - 1).getName() + "] 님의 예약 정보");
                        System.out.println("==============================================================");
                        System.out.println("잠시 후 메인 화면으로 이동합니다.");
                        Thread.sleep(2000);

                        // 예약 정보를 맵에 추가
                        reservationMap.put(passengers.get(passengers.size() - 1).getName(), sf);
                        System.out.println(bookNum + " " + sf);
                        break; // 예약 후 종료하고 메인 메뉴로 돌아가도록
                    }
                }
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private void passengerInfo(Flight flight) { // 사용자 정보 입력
        System.out.println("예약자 정보를 입력하세요");
        System.out.print("이름 : ");
        String name = sc.next();

        String birthDateStr = "";
        boolean validBirthDate = false;
        while (!validBirthDate) {
            System.out.printf("생년월일(6자리) : ");
            birthDateStr = sc.next();

            // 생년월일이 6자리 숫자인지 확인
            if (birthDateStr.length() == 6 && birthDateStr.matches("\\d{6}")) {
                validBirthDate = true; // 유효한 입력이면 종료
            } else {
                System.out.println("생년월일은 6자리 숫자여야 합니다. 예: 010101");
            }
        }

        try {
            int birthDate = Integer.parseInt(birthDateStr);
            Passenger p = new Passenger(name, birthDate);

            // 만 15세 미만 / 국제선이면 예약 불가
            if (!p.man15() && flight.getInternationalFlight()) {
                System.out.println("만 15세 미만은 국제선 예약 불가입니다.");
            } else {
                System.out.println("결제 비밀번호를 입력하세요");
                String pw = sc.next();
                p = new Passenger(name, birthDate, pw);
                passengers.add(p); // 예약 명단에 승객 추가
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 생년월일을 숫자 6자리로 입력해주세요.");
        }
    }

    private int setSelection(Flight flight) {
        int seatNum = -1;
        while (true) {
            try {
                System.out.println("==============================================================");
                System.out.println("좌석번호를 선택해주세요");
                flight.seatToString(); // 빈좌석이 보이는 print
                int seatInt = sc.nextInt() - 1;
                sc.nextLine();
                if (seatInt + 1 < 1 || seatInt + 1 > 20) { // 남은 좌석이 1~20 사이에 있는지
                    System.out.println("존재하지 않는 좌석입니다.");
                } else if (flight.getSeats().get(seatInt).equals("XX")) {
                    System.out.println("이미 예약된 자석입니다.");
                } else {
                    flight.getSeats().set(seatInt, "XX"); // 좌석수정
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

    public void checkReservation(String string) {
        int index = search("예약확인");
        if (index != -1) {
            checkpassword(index);
        } else {
            System.out.println("예약된 승객이 없습니다.");
        }
    }

    private void checkpassword(int index) {
        System.out.println("결제 비밀번호");
        String pw = sc.next();
        System.out.println();
        if (passengers.get(index).getPw().equals(pw)) {
            System.out.println("비밀번호가 일치합니다");
            System.out.println(ticketPrint(reservationMap, passengers.get(index).getName()));
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
        }
    }

    String ticketPrint(Map<String, Flight> reservationMap, String name) {
        int index = -1;
        if (passengers != null) {
            for (int i = 0; i < passengers.size(); i++) {
                if (passengers.get(i).getName().equals(name)) {
                    index = i;
                }
            }
        }
        if (index != -1) {
            int seat = Integer.parseInt(passengers.get(index).getSeat()) + 1;
            return "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n\n" +
                    "\t" + name + "님의 티켓정보" +
                    "| 좌석 : " + seat + "번\n" +
                    "." + reservationMap.get(name) + "\n\n" +
                    "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ";
        } else {
            return "예약 정보가 없습니다.";
        }
    }

    private int search(String str) {
        System.out.println("===================== " + str + " =====================");
        System.out.print("예약자 이름: ");
        String name = sc.next();
        sc.nextLine();
        int index = -1;
        if (passengers != null) {
            for (int i = 0; i < passengers.size(); i++) {
                if (passengers.get(i).getName().equals(name)) {
                    index = i;
                }
            }
        }
        return index;
    }

    // 티켓 파일로 저장
    public void tickeSave(String string) {
        int index = search("티켓 저장");
        checkpassword(index);
        fc.ticketSaveFile(reservationMap, passengers.get(index).getName());
    }

    // 항공편목록 flights을 외부에서 접근하는 getter메소드
    public static ArrayList<Flight> getFlights() {
        return flights;
    }

    
    public static Map<String, Flight> getReservationMap() {
        return reservationMap;
    }
}
