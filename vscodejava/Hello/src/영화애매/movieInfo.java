package 영화애매;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class movieInfo {
    private String type; // 영화 종류
    private String time; // 상영시간
    private int price; // 표가격
    private DecimalFormat priceFormat = new DecimalFormat("#,###원"); // 가격 포맷
    private Boolean adultInfo; // 성인 여부(True:19세이상, False:19세미만)
    private ArrayList<String> seats; // 좌석 번호(1번부터100번까지)

    // 영화 종류
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // 상영시간
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    // 표가격
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // 가격 포맷
    public DecimalFormat getPriceFormat() {
        return priceFormat;
    }

    public void setPriceFormat(DecimalFormat priceFormat) {
        this.priceFormat = priceFormat;
    }

    // 성인 여부(True:19세이상, False:19세미만)
    public Boolean getAdultInfo() {
        return adultInfo;
    }

    public void setAdultInfo(Boolean adultInfo) {
        this.adultInfo = adultInfo;
    }

    // 좌석 번호(1번부터100번까지)
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
        return "[영화 제목 =" + type + ", 상영시간 =" + time + ", 표 가격 =" + price + "]";
    }
}
