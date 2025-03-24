package a0324;

public class singleton {
    // static 변수
    private static singleton instance = new singleton();

    // 생성자에 private 접근 제어한자
    private singleton() {
        System.out.println("객체 생성");

    }
    // static 메서드
    public static singleton getinstance(){
        System.out.println("객체 리턴");
        return instance;
    }
}
