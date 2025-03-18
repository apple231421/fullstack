package a0318;

// 원기둥의 부피 =  r * r * h * 3.14
public class cylinder {
    public static void main(String[] args) {
        double r = 7; // 반지름
        double h = 5; // 높이
        double v = volume(r, h); // 부피
        System.out.printf("반지름이 %.0f, 높이가  %.0f인 원기둥의 부피%.1f ", r, h, v);

    }

    public static double volume(double r, double h) {
        return Math.PI * r * r * h;
    }
}
