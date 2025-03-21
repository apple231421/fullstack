package a0321;

public class mymath1 {
    public static void main(String[] args) {

        // int a = mymath.add(5, 6); mymath int 앞에 static 쓰면 객체없이 사용가능
        mymath mm = new mymath(); // 2.객체 생성
        int m1 = mm.add(5, 6); // 3.객체 사용
        int m2 = mm.subtract(9, 6); // 3.객체 사용
        int m3 = mm.multiplay(4, 5); // 3.객체 사용
        double m4 = mm.divide(6, 2); // 3.객체 사용
        int m5 = mm.max(15, 6); // 3.객체 사용

        System.out.println("m1 += " + m1);
        System.out.println("m2 -= " + m2);
        System.out.println("m3 *= " + m3);
        System.out.println("m4 /= " + m4);
        System.out.println("m5 >= " + m5);
    }
}

// 사칙연산을 수행하는 메서드를 가진 mymath class
// 메서드 클래스 영역에 정의 가능
// 1. mymath 클래스 작성
// 2. mymath 객체 생성
// 3. mymath 객체 사용

// mymath 클래스 작성
class mymath {

    int add(int a, int b) {
        int result = a + b;
        return result;
    }

    int subtract(int a, int b) {
        return a - b;

    }

    int multiplay(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        return a / b;
    }

    // 큰수 구하기
    int max(int a, int b) {
        int result;
        if (a > b) {
            result = a;
        } else {
            result = b;
        }
        return result;
    }
}