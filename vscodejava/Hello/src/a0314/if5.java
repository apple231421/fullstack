package a0314;

import java.util.Scanner;

public class if5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("쿠폰등급을 입력하세요 : ");
        int a = scan.nextInt(); // 쿠폰등급

        if (a == 2) {
            System.out.println("발급받은 쿠폰 2000");
        } else if (a == 3) {
            System.out.println("발급받은 쿠폰 3000");
        } else {
            System.out.println("발급받은 쿠폰 500");
        }
    }
}