package a0319;

import java.util.Arrays;

public class lotto1 {
    public static void main(String[] args) {
        // 1부터 45까지의 값을 저장할 배열을 생성
        int[] ball = new int[45];
        
        // 배열 ball에 1부터 45까지의 값을 채움
        for (int i = 0; i < ball.length; i++) {
            ball[i] = i + 1; // ball[i]에 1부터 45까지 값을 순차적으로 저장
        }

        // 배열의 초기 상태 출력 (1부터 45까지 순차적으로 저장된 배열)
        System.out.println(Arrays.toString(ball));

        var n = 0;  // 임시 변수 n (랜덤 인덱스를 저장)
        var tmp = 0; // 임시 변수 tmp (값을 교환할 때 사용)

        // 배열을 섞는 코드 (1000번 섞는 코드가 주석처리됨)
        // for (int i = 0; i < 1000; i++) {
        //     n = (int) (Math.random() * 45);  // 0부터 44까지의 랜덤 인덱스 생성
        //     tmp = ball[0];  // ball[0] 값을 tmp에 저장
        //     ball[0] = ball[n];  // ball[0]에 ball[n] 값을 넣음
        //     ball[n] = tmp;  // ball[n]에 tmp(원래 ball[0] 값)를 넣음
        // }
        // System.out.println(Arrays.toString(ball));

        // 6개의 공을 랜덤하게 섞는 코드
        for (int i = 0; i < 6; i++) {
            n = (int) (Math.random() * 45); // 0부터 44까지의 랜덤 인덱스 생성
            tmp = ball[i];  // ball[i] 값을 tmp에 저장
            ball[i] = ball[n];  // ball[i]에 ball[n] 값을 넣음
            ball[n] = tmp;  // ball[n]에 tmp(원래 ball[i] 값)를 넣음
        }

        // 섞인 배열을 출력 (6개의 숫자가 섞인 배열)
        System.out.println(Arrays.toString(ball));

        // 첫 6개의 랜덤 선택된 숫자를 출력
        for (int i = 0; i < 6; i++) {
            System.out.printf("ball[%d]=%d%n", i, ball[i]);  // ball 배열의 6개 값 출력
        }
    }
}
