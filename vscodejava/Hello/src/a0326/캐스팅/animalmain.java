package a0326.캐스팅;

public class animalmain {
    public static void main(String[] args) {
        animal eagle = new eagle();

        eagle.sleep();
        // eagle.eat(); 에러남

        eagle eagleobj = (eagle) eagle; // 강제 형 변환
        eagleobj.eat(); // eagle 클래스의 eat()메서드

        System.out.println(eagle instanceof animal);
    }
}
