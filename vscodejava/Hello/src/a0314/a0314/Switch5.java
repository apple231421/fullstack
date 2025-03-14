package a0314;

import java.util.Scanner;

public class Switch5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("월을 입력하세요 : ");
        int a = scan.nextInt(); // 월

        switch (a) {
            case 12:
            case 1:
            case 2:
                System.out.println("winter");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("fall");
                break;
            default:
                System.out.println("잘못된 값입니다");
                break;
        }
        // if (a >= 1 && a <= 2 || a == 12) {
        // System.out.println("winter");
        // } else if (a >= 3 && a <= 5) {
        // System.out.println("spring");
        // } else if (a >= 6 && a <= 8) {
        // System.out.println("summer");
        // } else if (a >= 9 && a <= 11) {
        // System.out.println("fall");
        // } else {
        // System.out.println("잘못된 달입니다");
        // }

    }
}