package a0318;

public class method2 {

    public static void main(String[] args) {

        int sum1 = add(5, 10);
        System.out.println("결과1 출력 : " + sum1);
        System.out.println();

        int subtract1 = subtract(10, 5);
        System.out.println("결과2 출력 : " + subtract1);
        System.out.println();

        int multiply1 = multiply(10, 5);
        System.out.println("결과3 출력 : " + multiply1);
        System.out.println();

        int divide1 = divide(10, 5);
        System.out.println("결과4 출력 : " + divide1);
        System.out.println();

    }

    public static int add(int a, int b) {
        System.out.println(a + "+" + b + " 연산수행");
        int sum = a + b;
        return sum;
    }

    private static int subtract(int x, int y) {
        System.out.println(x + "-" + y + " 연산수행");
        int subtract = x - y;
        return subtract;
    }

    private static int multiply(int num1, int num2) {
        System.out.println(num1 + "*" + num2 + " 연산수행");
        int multiply = num1 * num2;
        return multiply;
    }

    private static int divide(int num3, int num4) {
        System.out.println(num3 + "/" + num4 + " 연산수행");
        int divide = num3 / num4;
        return divide;
    }
    // add, subtract ,multiply, divide
}