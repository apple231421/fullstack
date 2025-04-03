package 영화애매;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class movieInfo {
    private String type; // 영화 종류
    private String time; // 상영시간
    private int price; // 표가격
    private DecimalFormat priceFormat = new DecimalFormat("#,###원"); // 가격 포맷
    private Boolean adultInfo; // 성인 여부(True:19세이상, False:19세미만)
    private ArrayList<String> seats;
    

    // 생성자
    public movieInfo(String type, String time, int price, Boolean adultInfo) {
        this.type = type;
        this.time = time;
        this.price = price;
        this.adultInfo = adultInfo;
        seats = new ArrayList<>();
    

        // 1번부터 48번까지 좌석번호 (6*8 = 48개)
        for (int i = 1; i <= 48; i++) {
            seats.add(i + "");
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public DecimalFormat getPriceFormat() {
        return priceFormat;
    }

    public void setPriceFormat(DecimalFormat priceFormat) {
        this.priceFormat = priceFormat;
    }

    public Boolean getAdultInfo() {
        return adultInfo;
    }

    public void setAdultInfo(Boolean adultInfo) {
        this.adultInfo = adultInfo;
    }

    public ArrayList<String> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<String> seats) {
        this.seats = seats;
    }

    // 영화 정보 출력(제목,시간,가격)
    @Override
    public String toString() {
        // 가격을 포맷에 맞춰 표시 (천 단위 구분 기호 추가)
        String priceComma = priceFormat.format(price);
        return "[" + "영화 제목 : " + type + ", 상영시간 : " + time + ", 표 가격 : " + price + "]";
    }

    // 좌석 정보를 6개씩 출력
    public void seatToString() {
        System.out.println("        _________|_______________________|_______");

        // 6개의 열로 8개씩 출력
        for (int i = 0; i < seats.size(); i += 6) {
            System.out.println("       |                                         |");

            // 다음 인덱스가 유효한지 확인 후 출력
            if (i + 5 < seats.size()) {
                System.out.printf("       |   [%2s]   [%2s]   [%2s]   [%2s]   [%2s]   [%2s]   |\n",
                        seats.get(i), seats.get(i + 1), seats.get(i + 2), seats.get(i + 3),
                        seats.get(i + 4), seats.get(i + 5));
            } else {
                // 남은 좌석이 6개 미만인 경우
                for (int j = 0; j < 6; j++) {
                    if (i + j < seats.size()) {
                        System.out.printf("       [%2s]   ", seats.get(i + j));
                    } else {
                        System.out.print("       [   ]   "); // 남은 좌석은 비어있는 것으로 표시
                    }
                }
                System.out.println("|");
            }
        }

        System.out.println("       |                                         |");
        System.out.println("       |_________________________________________|");
    }

}
