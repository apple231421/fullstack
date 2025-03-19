package a0319;

public class gugudan1 {
    public static void main(String[] args) {
        // 10x10 크기의 2차원 배열 생성 (구구단을 저장하기 위한 배열)
        int[][] gugudan = new int[10][10];

        // 구구단을 계산하여 배열에 저장
        // i는 1부터 9까지 반복 (구구단의 첫 번째 숫자)
        // j는 1부터 9까지 반복 (구구단의 두 번째 숫자)
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                // i와 j를 곱하여 구구단 값을 저장
                gugudan[i][j] = i * j;
            }
        }

        // 특정 값 출력 (2 X 7의 결과 출력)
        System.out.printf("2 X 7 = %d\n", gugudan[2][7]);

        // 특정 값 출력 (9 X 4의 결과 출력)
        System.out.printf("9 X 4 = %d\n", gugudan[9][4]);
    }
}
