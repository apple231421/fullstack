package a0314;

import java.util.Scanner;

public class moverate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print(" 평점을 입력하세요 : ");
        double a = scan.nextDouble(); //

        if (a <= 9) {
            System.out.println("어바웃타임");
        }
        if (a <= 8) {
            System.out.println("토이 스토리");
        }
        if (a <= 7) {
            System.out.println("고질라");
        }

    }
}
