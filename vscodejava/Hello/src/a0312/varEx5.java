package a0312;

public class varEx5 {
    public static void main(String[] args) {
        String a = "라면";
        int b = 800;
        double c = 0.12;
        boolean d = false;
        // s는 String d는 int f는 double ex) 1f는 소수첫째자리까지 나타내라 b는 boolean
        System.out.printf("상품-%s 가격-%d원 무게-%fkg 할인여부-%b",
                a, b, c, d);
    }
}
