package a0314;

import java.util.Scanner;

public class Switch2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("쿠폰등급을 입력하세요 : ");
        int a = scan.nextInt(); // 쿠폰등급

        switch(a){
            case 1:
                System.out.print("1등급 : 쿠폰 1000");
                break;
                // 2랑 3이랑 나오고 싶은값이 같으면 아래처럼 사용
            case 2:
            case 3:
                System.out.print("3등급 : 쿠폰 3000");
                break;
            default :
                System.out.print("없는 등급입니다");

        }
    }
}