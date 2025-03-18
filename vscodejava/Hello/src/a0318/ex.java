package a0318;

public class ex {
    public static void main(String[] args) {
        int r = 3;
        double v = val(r);
        System.out.printf("한 변의 길이가 %d이고, 부피는 %.0f이다.", r, v);
    }

    public static double val(int r) {
        return r * r * r ;
    }
}
