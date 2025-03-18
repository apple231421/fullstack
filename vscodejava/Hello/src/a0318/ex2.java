package a0318;

public class ex2 {
    public static void main(String[] args) {
        int x = 5;
        System.out.println("x1= " + x); // 1. x = 5출력
        print(x); // 5넣고             // 2. print() 함수 호출
        System.out.println("x2= " + x); // 6. x = 5 출력
    }

    private static void print(int x) {
        System.out.println("x3= " + x); // 3. x = 5 출력 (main의 x가 전달)
        x = x + 10;                    // 4. x 값이 10 증가 (지역변수)
        System.out.println("x4= " + x); // 5. x = 15 출력
    }
}
