package a0319;

public class simplemerge {
    public static void main(String[] args) {
        // 짝수 배열
        int[] evens = { 0, 2, 4, 6, 8 };
        // 홀수 배열
        int[] odds = { 1, 3, 5, 7, 9 };

        // 간단한 병합 함수 호출하여 결과 배열 생성
        int[] result = simplemerge(evens, odds);

        // 결과 출력
        System.out.printf("결과 : ");
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%d ", result[i]); // 병합된 배열 출력
        }
    }

    // 두 배열을 교차로 병합하는 함수
    private static int[] simplemerge(int[] a, int[] b) {
        // a 배열과 b 배열의 길이를 합친 새로운 배열 생성
        int[] arr = new int[a.length + b.length]; // evens와 odds 배열을 합친 길이의 배열

        // 새로운 배열에 짝수와 홀수를 교차로 삽입
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                // 짝수 인덱스에는 evens 배열의 원소를 넣음
                arr[i] = a[i / 2];
            } else {
                // 홀수 인덱스에는 odds 배열의 원소를 넣음
                arr[i] = b[i / 2];
            }
        }

        // 병합된 배열 반환
        return arr;
    }
}
