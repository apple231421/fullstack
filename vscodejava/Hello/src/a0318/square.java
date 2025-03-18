package a0318;

public class square {

    public static void main(String[] args) {
        int n = 4;
        int s = square(n);
        System.out.printf("한 변의 길이가 %d인 정사각형의 넓이:%d", n, s);
    }

    public static int square(int length) {
        // static 객체 생성없이 square 함수를 부르려면 ..
        int result = length * length;
        return result;

    }

}