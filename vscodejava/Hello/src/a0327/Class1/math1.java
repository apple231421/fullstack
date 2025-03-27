

public class math1 {
    public static void main(String[] args) {
        System.out.println(Math.ceil(10.0)); // 10.0
        System.out.println(Math.ceil(10.1)); // 10.0

        System.out.println(Math.floor(10.1)); // 10
        System.out.println(Math.floor(10.9)); // 10

        System.out.println(Math.round(10.0)); // 10
        System.out.println(Math.round(10.4)); // 10
        System.out.println(Math.round(10.5));// 11

        System.out.println(Math.max(3.14, 3.14159)); // 3.14159
        System.out.println(Math.min(3.14, 3.14159)); // 3.14

        System.out.println(Math.max(-10, -11)); // -10
        System.out.println(Math.min(-10, -11)); // -11
        System.out.println((int) (Math.random() * 100)); //0~99
    }
}
