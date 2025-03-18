package a0318;

public class ex3 {
    public static void main(String[] args) {
        // 연비 = 이동거리 / 사용량
        double L = 8.86; // 리터당 주행거리가능
        double totalkm = 182.736; // 총 주행거리
        double km = calc(L, totalkm); // 연비 계산
        System.out.printf("자동차의 연비는 %.2f km/L", km);

    }

    public static double calc(double L, double totalkm) {
        return totalkm / L;
    }

}
// calc - 메소드 이름
// double L, double totalkm - (매개변수, 입력변수, 파라미터)
// return totalkm / L - 반환값
// double 반환타입