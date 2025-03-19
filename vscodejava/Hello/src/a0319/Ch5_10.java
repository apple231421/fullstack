package a0319;

public class Ch5_10 {
    public static void main(String[] args) {
        int[][] score = {
                { 100, 95, 46 },
                { 20, 20, 20 },
                { 30, 30, 30 },
                { 40, 40, 40 }
        };
        int totalKr = 0; // 국어
        int totalEng = 0; // 영어
        int totalMath = 0; // 수학
        // 열값구하는거
        for (int i = 0; i < score.length; i++) {
            totalKr += score[i][0];
        }
        for (int i = 0; i < score.length; i++) {
            totalEng += score[i][1];
        }
        for (int i = 0; i < score.length; i++) {
            totalMath += score[i][2];
        }

        System.out.println("번호  국어  영어  수학  합계  평균");
        System.out.println("================================");
        // 행값구하는거
        for (int i = 0; i < score.length; i++) {
            int sum = score[i][0] + score[i][1] + score[i][2]; // 합 값 구하는거
            double average = (double) sum / score[i].length; // 평균
            System.out.printf("%d  %d  %d  %d  %d  %.1f\n", i + 1, score[i][0], score[i][1], score[i][2], sum, average);

        }
        System.out.println("================================");
        System.out.printf("총점:  %d  %d  %d", totalKr, totalEng, totalMath);

    }
}