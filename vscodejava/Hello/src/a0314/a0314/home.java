package a0314;

import java.util.Scanner;

public class home {

    // 3개의 수를 입력받아 제일 큰수 구하기
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("a를 입력하세요 : ");
        int a = scan.nextInt();
        System.out.print("b를 입력하세요 : ");
        int b = scan.nextInt();
        System.out.print("c를 입력하세요 : ");
        int c = scan.nextInt();

        int max = a; 

        if (b > max) {
            max = b; 
        }

        if (c > max) {
            max = c; 
        }

        // 가장 큰 수 출력
        System.out.println("가장 큰 수는 " + max + "입니다.");

        scan.close();
    }
}
