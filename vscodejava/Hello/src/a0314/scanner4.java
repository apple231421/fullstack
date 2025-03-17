package a0314;

import java.util.Scanner;

public class scanner4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자를 입력하세요 : ");
        float a = scanner.nextFloat();

        a = (a + 0.005f) * 100; // 159.754
        System.out.println(a);
        int i = (int) a; // 159
        System.out.println(i);
        a = (float) i / 100; // 1.59
        System.out.println(a);
    }
}
