package a0312;

public class var7 {
    public static void main(String[] args) {
        // 정수 대표 int
        byte a = 127; // -128~127 사이값만 가능
        short b = 32767; // -32,768 ~ 32,767
        int c = 2147483647; // -2,147,483,648 ~ 2,147,483,647
        long d = 9223372036854775807L; // -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807

        // 실수 대표 double
        float e = 10.0f;
        double f = 10.0;

        // 정수형
        // byte` : -128 ~ 127 (1byte, 2⁸)

        // short` : -32,768 ~ 32,767 (2byte, 2¹⁶)

        // int` : -2,147,483,648 ~ 2,147,483,647 (약 20억) (4byte, 2³²)

        // long` : -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807 (8byte, 2⁶⁴)
        // 실수형
        // ` float` : 대략 -3.4E38 ~ 3.4E38, 7자리 정밀도 (4byte, 2³²)

        // double` : 대략 -1.7E308 ~ 1.7E308, 15자리 정밀도 (8byte, 2⁶⁴)
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);

        // int 1num = 10; 변수이름은 숫자로 시작할 수 없다
        // int int = 20; 예약어로 사용할 수 없다 )int class long ... 등등
        // 변수명에는 영문자 , 숫자 , 달러기회($) 또는 밑줄(_)만 사용
        // 변수명 소문자로 시작하는것이 일반적, 소문자로 시작해서 그 이후의 각단어는 대문자로 시작
        // 낙타 표기법(camel case)사용한다. ex) OrderDetail, MyAccount

        // 자바 정리
        // 자바에서 클래스 이름의 첫 글자는 대문자로 시작한다. 그리고 나머지는 모두 첫 글자 소문자로 시작한다
        // 낙타 표기법 (camel case)
        // 클래스 : Person, OrderDetail
        // 변수를 포함한 나머지 : firstName, userAccount

        // 예외2개
        // 상수 모두 대문자를 사용하고 언더바로 구분
        // USER_LIMIT
        // 패키지는 모두 소문자
    }
}
