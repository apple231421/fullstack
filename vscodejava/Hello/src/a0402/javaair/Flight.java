package a0402.javaair;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Flight {
    // 목적지, 비행시간, 금액 등의 정보를 다루는 클래스
    private String destination; // 목적지 (예: 제주, 방콕 등)
    private String time; // 비행시간 (예: 11:55)
    private int price; // 가격 (예: 380000)
    private DecimalFormat priceFormat = new DecimalFormat("#,###원"); // 가격을 천 단위 구분 기호로 포맷하는 객체
    private Boolean internationalFlight; // 국제선 여부 (True: 국제선, False: 국내선)
    private ArrayList<String> seats; // 좌석 번호 리스트 (1번부터 20번까지)

    // 생성자: 항공편 정보와 좌석 초기화
    public Flight(String destination, String time, int price, Boolean internationalFlight) {
        this.destination = destination; // 목적지
        this.time = time; // 출발 시간
        this.price = price; // 가격
        this.internationalFlight = internationalFlight; // 국제선 여부
        seats = new ArrayList<>(); // 좌석 리스트 초기화

        // 1번부터 20번까지의 좌석 번호를 문자열로 저장
        for (int i = 1; i <= 20; i++) {
            seats.add(i + ""); // 숫자를 문자열로 변환하여 리스트에 저장
        }
    }

    // 목적지 반환
    public String getDestination() {
        return destination;
    }

    // 목적지 설정
    public void setDestination(String destination) {
        this.destination = destination;
    }

    // 출발 시간 반환
    public String getTime() {
        return time;
    }

    // 출발 시간 설정
    public void setTime(String time) {
        this.time = time;
    }

    // 가격 반환
    public int getPrice() {
        return price;
    }

    // 가격 설정
    public void setPrice(int price) {
        this.price = price;
    }

    // 가격 포맷 반환
    public DecimalFormat getPriceFormat() {
        return priceFormat;
    }

    // 가격 포맷 설정
    public void setPriceFormat(DecimalFormat priceFormat) {
        this.priceFormat = priceFormat;
    }

    // 국제선 여부 반환
    public Boolean getInternationalFlight() {
        return internationalFlight;
    }

    // 국제선 여부 설정
    public void setInternationalFlight(Boolean internationalFlight) {
        this.internationalFlight = internationalFlight;
    }

    // 좌석 리스트 반환
    public ArrayList<String> getSeats() {
        return seats;
    }

    // 좌석 리스트 설정
    public void setSeats(ArrayList<String> seats) {
        this.seats = seats;
    }

    // 항공편 정보 출력 (목적지, 출발시간, 가격을 포함)
    @Override
    public String toString() {
        // 가격을 포맷에 맞춰 표시 (천 단위 구분 기호 추가)
        String priceComma = priceFormat.format(price);
        return " [" + "목적지: " + destination + ", 출발시간: " + time + ", 가격: " + priceComma + "]";
    }

    // 좌석 정보를 보기 좋게 출력 (4개씩 묶어서 출력)
    public void seatToString() {
        // 좌석을 4개씩 묶어서 출력 (각 행에 4개의 좌석 번호를 표시)
        for (int i = 0; i < seats.size() - 3; i += 4) {
            System.out.printf("|   [%2s]\t\t[%2s][%2s] \t\t [%2s]   |\n", seats.get(i), seats.get(i + 1),
                    seats.get(i + 2), seats.get(i + 3));
        }
    }

    // 좌석 배치는 다음과 같이 표시됩니다:
    // [1][2][3][4]
    // [5][6][7][8]
    // [9][10][11][12]
    // [13][14][15][16]
    // [17][18][19][20]
}
