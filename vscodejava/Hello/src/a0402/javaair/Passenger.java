package a0402.javaair;

import java.time.LocalDate;
import java.time.Period;

public class Passenger { // 예매 정보를 저장하고 나이 검증을 수행하는 클래스
    private String name;
    private int birthDate; // 생년월일 (예: 831016)
    private String pw; // 예약 비밀번호
    private String seat; // 좌석 번호

    // 이름과 생년월일로 승객 객체 초기화
    public Passenger(String name, int birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    // 이름, 생년월일, 비밀번호로 승객 객체 초기화
    public Passenger(String name, int birthDate, String pw) {
        this(name, birthDate);
        this.pw = pw;
    }

    // getter, setter 메서드들
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public boolean man15() {
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

        // 만 15세 이상이면 true 반환
        return age >= 15; // 15세 이상이면 true 반환
    }

	
}
