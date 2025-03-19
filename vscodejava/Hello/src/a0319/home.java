package a0319;

public class home {
    public static void main(String[] args) {
        // 배열 선언 및 초기화 (각 학생의 국어, 영어, 수학 점수)
        int[][] score = {
                { 100, 95, 46 }, // 1번
                { 20, 20, 20 }, // 2번
                { 30, 30, 30 }, // 3번
                { 40, 40, 40 } // 4번
        };

        // 각 행(학생별) 총점을 저장할 배열
        int[] rowsums = new int[score.length];

        // 각 열(과목별) 총점을 저장할 배열
        int[] colsums = new int[score[0].length];

        // 각 학생별 점수 합계 계산
        for (int i = 0; i < score.length; i++) {
            int rowsum = 0; // 현재 학생의 총점 저장 변수
            for (int j = 0; j < score[i].length; j++) {
                rowsum += score[i][j]; // 점수 누적
            }
            rowsums[i] = rowsum; // 계산된 총점 배열에 저장
        }

        // 각 과목별 점수 합계 계산
        for (int j = 0; j < score[0].length; j++) {
            int colsum = 0; // 현재 과목의 총점 저장 변수
            for (int i = 0; i < score.length; i++) {
                colsum += score[i][j]; // 점수 누적
            }
            colsums[j] = colsum; // 계산된 총점 배열에 저장
        }



        // 결과 테이블 출력
        System.out.println(" 번호|  국어  |  영어  |  수학  |  합계  |  평균");
        System.out.println("==================================================");

        // 학생별 성적 및 합계, 평균 출력
        for (int i = 0; i < score.length; i++) {
            double average = (double) rowsums[i] / score[i].length; // 평균 계산
            System.out.printf("  %d  | %3d점  | %3d점  | %3d점  | %3d점  | %.1f점\n",
                    i + 1, score[i][0], score[i][1], score[i][2], rowsums[i], average);
        }

        // 과목별 총점 출력
        System.out.println("==================================================");
        System.out.printf("총점 : %3d점    %3d점    %3d점", colsums[0], colsums[1], colsums[2]);
    }
}
