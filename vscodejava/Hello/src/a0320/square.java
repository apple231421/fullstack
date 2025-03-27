

public class square {
    int length; // 필드

    int area() {
        return length * length; // 메소드
    }

    // 메인 메소드
    public static void main(String[] args) {
        square s = new square(); // 객체 생성
        s.length = 4; // 필드 초기화
        System.out.printf("한 변의 길이가 %d인 정사각형의 넓이: %d", s.length, s.area()); // 결과 출력
    }
}

//객체지향프로그램(object-oriented programming) --OOP
//객체 지향 프로그램 장점
// 유지보수 좋음
// 코드 재사용이 수월함

//클래스 -->객체의 설계도
//클래스 토대로 만들어진 프로그램의 구성요소를 객체
// 클래스 설계 필드 메서드로 이루어져있음
// Dog d1 = new Dog() - Dog 객체만들어서 d1 연결