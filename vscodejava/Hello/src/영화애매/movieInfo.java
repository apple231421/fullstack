package 영화애매;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class movieInfo {
    private String type; // 영화 종류
    private String time; // 상영시간
    private int price; // 표가격
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

    // 영화 정보 출력(제목,시간,가격,성인)
    @Override
    public String toString() {
        return String.format(
                        "| %-7s: %-20s |\n" + // 제목
                        "| %-5s: %-20s |\n" + // 상영시간
                        "| %-7s: %-20d |\n" + // 가격
                        "| %-7s: %-20s |\n" + // 19세용 여부
                        "==========================================\n",
                "제목", type,
                "상영시간", time,
                "가격", price,
                "연령가", adultInfo ? "19세" : "전체이용가");
    }

    // 좌석 정보를 6개씩 출력
    public void seatToString() {
        System.out.println("              ___________________________");
        System.out.println("             |                           |");
        System.out.println("             |           SCREEN          |");
        System.out.println("             |___________________________|");
        System.out.println("        _____|___________________________|_______");
        System.out.println("       |                                         |");
        // 6개의 열로 8개씩 출력
        for (int i = 0; i < seats.size(); i += 6) {
            System.out.println("       |                                         |");

            // 다음 인덱스가 유효한지 확인 후 출력
            if (i + 5 < seats.size()) {
                System.out.printf("       | [%2s]   [%2s]   [%2s]   [%2s]   [%2s]   [%2s] |\n",
                        seats.get(i), seats.get(i + 1), seats.get(i + 2), seats.get(i + 3),
                        seats.get(i + 4), seats.get(i + 5));
            }
        }

        System.out.println("       |                                         |");
        System.out.println("       |_________________________________________|");
    }
    

}