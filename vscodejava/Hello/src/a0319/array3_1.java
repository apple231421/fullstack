package a0319;

public class array3_1 {
    public static void main(String[] args) {
        int[] numbers = {65, 74, 23, 75, 68, 96, 88, 98, 54};

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : numbers) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax && num < firstMax) {
                secondMax = num;
            }
        }

        System.out.println("두 번째로 큰 수: " + secondMax);
    }
}