package a0317;

public class ex111 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 100; i++) {
            if (i % 5 == 0) {
                sum += i;
            }
        }

        System.out.println("5의 배수의 합 : " + sum);

        int evensum = 0; // 짝수
        int oddsum = 0; // 홀수
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                evensum += i;
            }
            if (i % 2 != 0) {
                oddsum += i;
            }

        }
        System.out.println("짝수의 합 : " + evensum);
        System.out.println("홀수의 합 : " + oddsum);
    }
}
