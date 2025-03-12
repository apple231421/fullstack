package a0312;

public class varEx6 {
    public static void main(String[] args) {
        double num1 = 77.0;
        double sum = (num1 - 32.0) / 1.8;

        // s는 String d는 int f는 double ex) 1f는 소수첫째자리까지 나타내라 b는 boolean
        System.out.printf("화씨 %.1f도는 섭씨로 %.1f도입니다", num1, sum);
    }
}
