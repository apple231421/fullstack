package a0314;

import java.util.Scanner;

public class scanner3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자를 입력하세요 : ");
        float a = scanner.nextFloat();
        

        System.out.printf("%.2f", a );

    }
}
