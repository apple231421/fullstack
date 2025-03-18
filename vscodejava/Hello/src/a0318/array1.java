package a0318;

public class array1 {
    public static void main(String[] args) {

        int[] numbers = { 1, 2, 3, 4, 5 };
        System.out.println(sumarray(numbers));
    }

    private static int sumarray(int[] numbers) {
        int sum = 0;
        // for (int i = 0; i < numbers.length; i++) {
        // sum += numbers[i];
        // }
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
