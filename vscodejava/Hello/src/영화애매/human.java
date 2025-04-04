package 영화애매;

import java.time.LocalDate;
import java.time.Period;

public class human {
    private String name; // 이름
    private int birthDate; // 생년월일 ex) 011010
    private String pw; // 예약 번호
    private String seat; // 좌석 번호

    public human(String name, int birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public human(String name, int birthDate, String pw) {
        this(name, birthDate);
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void getBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getPw() {
        return pw;
    }

    public void setNum(String pw) {
        this.pw = pw;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public boolean age19() {
        // 생년월일에서 년, 월, 일을 추출
        int y = birthDate / 10000; // 년
        int m = (birthDate % 10000) / 100; // 월
        int d = birthDate % 100; // 일

        // 2자리 연도를 처리 (예: 83 -> 1983년, 25 -> 2025년)
        if (y <= 25) {
            y += 2000; // 2000년대 출생자 (예: 83 -> 1983)
        } else {
            y += 1900; // 1900년대 출생자 (예: 83 -> 1983)
        }

        LocalDate birthDateObj = LocalDate.of(y, m, d);
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthDateObj, currentDate).getYears();

        // 19세 이상이면 true 반환
        return age >= 19;
    }
}
