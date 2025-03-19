package a0319;

public class arraytoparameter {
    public static void main(String[] args) {
        // 짝수 배열 (0부터 18까지의 짝수)
        int[] evens = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18 };

        // 소수 배열 (2부터 19까지의 소수)
        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19 };

        // 짝수 배열의 합을 구하여 evensum에 저장
        int evensum = sum(evens);

        // 소수 배열의 합을 구하여 primesum에 저장
        int primesum = sum(primes);

        // 짝수 배열의 합을 출력
        System.out.printf("짝수 배열의 합 : %d\n", evensum);

        // 소수 배열의 합을 출력
        System.out.printf("소수 배열의 합 : %d\n", primesum);
    }

    // 배열을 받아서 그 합을 반환하는 메서드
    private static int sum(int[] arr) {
        int sum = 0; // 합을 저장할 변수 초기화

        // 배열의 각 요소를 더하는 반복문
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // 배열의 i번째 요소를 sum에 더함
        }

        // 계산된 합을 반환
        return sum;
    }
}
