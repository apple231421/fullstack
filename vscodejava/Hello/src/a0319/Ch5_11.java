package a0319;

public class Ch5_11 {
    public static void main(String[] args) {
        int[][] score = {
                { 100, 95, 46 },
                { 20, 20, 20 },
                { 30, 30, 30 },
                { 40, 40, 40 }
        };
        System.out.println("번호 국어 영어 수학 합계 평균");
        System.out.println("=============================");

        int sum = 0;
        double average;

        // 학생의 총합
        for (int i = 0; i < score.length; i++) {
            System.out.printf("%3d", i + 1);
            for (int j = 0; j < score[i].length; j++) {
                System.out.printf("%5d", score[i][j]);
            }
            System.out.printf("%5d  %.1f\n", sumRows(score, i), average(score, i));
        }

        System.out.println("=============================");

        System.out.print("총점:");
        // 과목의 총합
        for (int i = 0; i < score[i].length; i++) {
            System.out.printf("%4d ", sumColumns(score, i));
        }
        System.out.println();
        int n = score.length;
        System.out.println(n);

    }

    private static int sumRows(int arr[][], int n) { // 가로 합계
        int sum = 0;
        for (int i = 0; i < arr[n].length; i++) {
            sum += arr[n][i];
        }
        return sum;
    }

    private static int sumColumns(int[][] arr, int n) { // 세로 합계
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i][n];
        }
        return sum;
    }

    private static double average(int[][] arr, int n) { // 가로 평균
        int sum = sumRows(arr, n);
        double average = (double) sum / arr[n].length;
        return average;
    }
}
