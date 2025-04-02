package a0402.calendar;

import java.util.Calendar;

public class Calendar2 {
    public static void main(String[] args) {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2025, Calendar.JANUARY, 1);

        Calendar endDate = Calendar.getInstance();
        endDate.set(2025, Calendar.DECEMBER, 31);
        long startMillis = startDate.getTimeInMillis();
        // getTimeInMillis()1970.1.1 부터 지정한 시간까지를 1/1000초로 계산
        System.out.println(startMillis);
        long endMillis = endDate.getTimeInMillis();
        System.out.println(endMillis);
        long diff = endMillis - startMillis;
        long diffDay = diff /(24*60*60*1000);
        System.out.println("두 날자의 차이는 " +diffDay+"일 입니다");
    }
}
