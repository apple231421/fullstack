package a0313;

public class Logical1 {

    public static void main(String[] args) {
        System.out.println("&&: AND 연산");
        System.out.println(true && true); // true
        System.out.println(true && false); // false
        System.out.println(false && false); // false

        System.out.println("||: or 연산"); // 여러개중 하나만 true면 true
        System.out.println(true && true); // true
        System.out.println(true && false); // true
        System.out.println(false && false); // false

        System.out.println("! 연산"); // false
        System.out.println(!true); // false
        System.out.println(!false); // true

        System.out.println("변수 활용"); // true
        boolean a = true;
        boolean b = false;
        System.out.println(a && b); // false
        System.out.println(a || b); // true
        System.out.println(!a); // false
        System.out.println(!b); // true
    }
}