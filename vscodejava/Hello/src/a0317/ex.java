package a0317;

import java.util.Scanner;

import a0314.scanner1;

public class ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("마름모의 반쪽 높이를 입력하세요: ");
        int rows = scanner.nextInt(); // 사용자 입력 받기

        // 위쪽 삼각형 (정삼각형 피라미드)
        for (int i = 1; i <= rows; i++) {

            // 공백 출력
            for (int j = rows - i; j > 0; j--) {
                System.out.print(" ");
            }

            // 별 출력
            // (2 * i - 1) 이거 말고 i * i를 사용하면 마름모가 모양이 이상함
            for (int k = 0; k < (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 아래쪽 역삼각형 (반전된 피라미드)
        for (int i = rows - 1; i >= 1; i--) {
            // 공백 출력
            for (int j = rows - i; j > 0; j--) {
                System.out.print(" ");
            }
            // 별 출력
            for (int k = 0; k < (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}
