package a0318;

public class ex1 {
    public static void main(String[] args) {
        int n = 3; //인분
        int g = 180; // 1인분 그램수
        double n_1 = 5.179; // 1g당 칼로리
        double kacl = val(n_1, g, n); // 토탈 칼로리
        System.out.printf("삼겹살 %d인분의 칼로리: %.2f Kcal", n, kacl);
    }

    public static double val(double n1, int g, int n) {
        return n1 * g * n;
    }
}
