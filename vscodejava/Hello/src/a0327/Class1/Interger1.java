

public class Interger1 {
    public static void main(String[] args) {

        int a = 10; // 기본형
        Integer num1 = new Integer(10);
        Integer num2 = new Integer(20);
        Integer num3 = new Integer(10);
        System.out.println(num1 < num2);
        System.out.println(num1 == num3); //false(주소비교)
        System.out.println(num1.equals(num3)); // true(값 비교)
    }

}