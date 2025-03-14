package a0314;

import java.util.Scanner;

public class if4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("템가격을 입력하세요 : ");
        int a = scan.nextInt(); // 템가격

        System.out.print("나이를 입력하세요 : ");
        int b = scan.nextInt(); // 나이

        int discount = 0;

        if (a >= 10000) {
            discount = discount + 1000;
            System.out.println("10000원 이상 구매,1000원할인");
        }

        if (b <= 10) {
            discount = discount + 1000;
            System.out.println("어린이, 1000원할인");
        }
        System.out.println("총 할인 금액 : " + discount + "원");

        a -= discount;
        System.out.println("총 금액은 "+a+"원입니다");
    }
}