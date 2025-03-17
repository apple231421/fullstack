package a0314;

import java.util.Scanner;

public class Switch3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("쿠폰등급을 입력하세요 : ");
        int grade = scan.nextInt(); // 쿠폰등급

        int a = switch(grade){
           case 1 -> 1000;
           case 2 -> 500;
           case 3 -> 300;
           default -> 0;
        };
        System.out.println(a);
    }
}