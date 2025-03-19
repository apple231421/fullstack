package a0319;

public class sum1 {
    public static void main(String[] args) {
        int sum = 0;
        float average = 0f;
        int[] score = { 100, 88, 100, 100, 90 };

        // Sum calculation
        for (int i = 0; i < score.length; i++) {
            sum += score[i];
        }

        // Average calculation
        average = sum / (float)score.length;

        // Output the sum and average
        System.out.println("합: " + sum);
        System.out.println("평균: " + average);
    }
}
