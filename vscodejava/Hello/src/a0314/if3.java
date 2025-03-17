package a0314;

import java.util.Scanner;

public class if3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int price = 10000;
        int age = 10;
        int discount = 0;

        if (price >= 10000) {
            discount = discount + 1000;
            System.out.println("10000이상 구매, 1000원할인");
        }
        if (age <=10) {
            discount = discount + 1000;
            System.out.println("어린이, 1000원할인");
        }

        System.out.println("총 할인 금액 : " + discount + "원");
    }
}
