

import java.util.Scanner;

public class home_switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = null; // 학생 점수 저장 배열
        int member = 0; // 학생 수 변수 선언

        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("1.학생수  | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("----------------------------------------------");
            System.out.print("선택> ");
            int slt = sc.nextInt(); // 원하는 옵션 선택 번호

            switch (slt) {
                case 1:
                    System.out.print("학생수> ");
                    member = sc.nextInt(); // 학생수 입력받기
                    numbers = new int[member]; // 학생 수 만큼 점수 받는곳
                    break;

                case 2:
                    if (numbers == null) {
                        System.out.println("먼저 학생 수를 입력하세요!");
                    } else {
                        for (int i = 0; i < numbers.length; i++) {
                            System.out.print((i + 1) + "번째 학생 점수 입력> ");
                            numbers[i] = sc.nextInt(); // 점수 입력받아 저장
                        }
                    }
                    break;

                case 3:
                    if (numbers == null) {
                        System.out.println("먼저 점수를 입력하세요!");
                    } else {
                        System.out.println("점수 리스트:");
                        for (int i = 0; i < numbers.length; i++) {
                            System.out.println((i + 1) + "번째 학생 점수: " + numbers[i]);
                        }
                    }
                    break;

                case 4:
                    if (numbers == null) {
                        System.out.println("먼저 점수를 입력하세요! (옵션 2)");
                    } else {
                        int max = numbers[0]; // 최고 점수
                        int sum = 0; // 총합

                        // 최고 점수 구하는 식
                        for (int i = 0; i < numbers.length; i++) {
                            int num = numbers[i];
                            if (num > max) {
                                max = num;
                            }
                            // 총 합계(평균 계산 때문에 구함)
                            sum += num;
                        }
                        double avg = (double) sum / numbers.length; // 평균 계산

                        System.out.println(" 분석 결과");
                        System.out.println("최고 점수: " + max);
                        System.out.printf("평균 점수: %.2f\n", avg);
                    }
                    break;

                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;

                default:
                    System.out.println("잘못된 번호입니다.");
                    break;
            }
        }
    }
}
