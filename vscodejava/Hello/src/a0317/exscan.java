package a0317;

import java.util.Scanner;

public class exscan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;

        while (true) {
            System.out.println("----------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("----------------------------------");
            System.out.print("선택> ");
            int num = sc.nextInt();
            // int num = Integer.parseInt(sc.nextLine());
            switch (num) {
                case 1:
                    System.out.print("예금액> ");
                    int a = sc.nextInt();
                    total += a;
                    break;
                case 2:
                    System.out.print("출금액> ");
                    int b = sc.nextInt();
                    total -= b;
                    break;
                case 3:
                    System.out.print("잔고> ");
                    System.out.println(total);
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;

                default:
                    System.out.println("올바른번호를 입력하세요.");
                    break;
            }
        }
    }
}
