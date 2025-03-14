package a0314;

import java.util.Scanner;

public class if2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("나이를 입력하세요 : ");
        int age = scanner.nextInt();

        if (age >= 20) {
            System.out.println("성인입니다");
        } else if (age <= 19) {
            System.out.println("중학생입니다");
        } else if (age <= 16) {
            System.out.println("중학생입니다");
        } else if (age <= 13) {
            System.out.println("초딩입니다");
        } else {
            System.out.println("아동입니다");
        }

    }
}
