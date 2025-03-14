package a0314;

import java.util.Scanner;

public class Switch4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("학점을 입력하세요 : ");
        String grade = scan.next(); // 쿠폰등급

        switch (grade) {
            case "A":
                System.out.print("탁월한 성과입니다");
                break;
            case "B":
                System.out.print("좋은 성과입니다");
                break;
            case "C":
                System.out.print("준수한 성과입니다");
                break;
            case "D":
                System.out.print("향상이 성과입니다");
                break;
            case "F":
                System.out.print("불합격입니다");
                break;
            default:
                System.out.print("잘못된 학점입니다");

        }

    }
}