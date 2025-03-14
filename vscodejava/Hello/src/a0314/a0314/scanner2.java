package a0314;

import java.util.Scanner;

public class scanner2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자를 입력하세요 : ");
        int word = scanner.nextInt();

        System.out.print("숫자를 입력하세요 : ");
        int word1 = scanner.nextInt();
        System.out.println("당신이 선택한 단어 : " + word +" "+ word1);

    }
}
