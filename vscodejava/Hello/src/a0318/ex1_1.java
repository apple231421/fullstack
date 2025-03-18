package a0318;

public class ex1_1 {
    public static void main(String[] args) {
        int n = 3; // 인분
        double x = cal(n);
        System.out.printf("삼겹살 %d인분의 칼로리: %.2f Kcal", n, x);
    }

    public static double cal(int amount) {
        int totalgram = amount * 180;
        double totalkcal = totalgram * 5.179;
        return totalkcal;
    }
}
