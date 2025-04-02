package a0402.calendar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateEx {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("기본 ISO 형식 : " + now);
        // 카스텀 포멧
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd / HH:mm:ss a");
        String formattedDate = now.format(formatter);
        System.out.println("포멧팅된 날짜 : " + formattedDate);
    }
}
// MM을 소문자로 쓰면 분으로 인식
// MM DD 두개를 써야 04-01 처럼 앞에 0 으로 채워짐
// HH 대문자를 쓴 이유는 24시간 표기
// 예를 소문자로 쓰면 12시간 표기 "yyyy-MM-dd HH:mm:ss a" 뒤 a는 am/pm 구분