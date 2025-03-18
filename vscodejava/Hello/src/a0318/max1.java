package a0318;

public class max1 {
    public static void main(String[] args) {
        System.out.println(max(10, 20));
        System.out.println(max(5, 3));
    }

    public static int max(int i, int j) {
        return (i > j) ? i : j;
    }
}
