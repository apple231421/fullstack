package a0314;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("쿠폰등급을 입력하세요 : ");
        int a = scan.nextInt(); // 쿠폰등급

        switch(a){
            case 1:
                System.out.print("1등급 : 쿠폰 1000");
                break;
            case 2:
                System.out.print("2등급 : 쿠폰 2000");
                break;
            case 3:
                System.out.print("3등급 : 쿠폰 3000");
                break;
            case 4:
                System.out.print("4등급 : 쿠폰 4000");
                break;
            default :
                System.out.print("없는 등급입니다");

        }
    }
}