package a0313;

public class Ex01 {

    public static void main(String[] args) {
        // 세자리 정수의 각 자릿수 총합을 출력하려 한다
        // num // 374
        // 정수 374의 각 자릿수의 총합 :14

        int num1 = 374;
        int result1 = num1 % 10; // 일의 자리 4

        int result2 = (num1 % 100) /10; // 십의자리 7

        int result3 = num1 / 100; // 백의자리 3

        int sum = result1 + result3 + result2;
        System.out.println("정수"+num1 +"의 각 자릿수의 총합: "+sum);

    }
}