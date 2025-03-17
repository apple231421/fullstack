package a0317;

import java.util.Scanner;

public class exscan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("1.덧셈  | 2.뺄셈 | 3.곱셈 | 4.나눗셈 | 5.종료");
            System.out.println("----------------------------------------------");
            System.out.print("선택> ");
            int num = sc.nextInt();

            System.out.print("첫 번째 숫자>");
            int a = sc.nextInt();
            System.out.print("두 번째 숫자>");
            int b = sc.nextInt();
            // int num = Integer.parseInt(sc.nextLine());
            if (num == 5) {
                System.out.println("프로그램을 종료합니다.");
                sc.close();
                return;
            }
            switch (num) {
                case 1:
                    int num1 = a + b;
                    System.out.println("결과:" + a + " + " + b + " = " + num1);
                    break;
                case 2:
                    int num2 = a - b;
                    System.out.println("결과:" + a + " - " + b + " = " + num2);
                    break;
                case 3:
                    int num3 = a * b;
                    System.out.println("결과:" + a + " * " + b + " = " + num3);
                    break;
                case 4:
                    if (b==0) {
                        System.out.println("0으로 나눌수 없습니다");
                    } else {
                        double num4 = a / b;
                        System.out.println("결과:" + a + " / " + b + " = " + num4);
                    }
                    break;
                default:
                    System.out.println("올바른번호를 입력하세요.");
                    break;
            }
        }
    }
}
