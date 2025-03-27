package a0327.exception1;

public class ExceptionEx04 {
    public static void main(String[] args) {
        try {
            checkNumber(-5);
        } catch (customException e) {
            System.out.println("예외발생: " + e.getMessage());
        }
    }

    // checkNumber(-5) 호출하여 음수 전달 >예외발생
    // catch(customException e)에서 예외를 잡고 예외 메시지를 출력한다

    private static void checkNumber(int num) throws customException {
        if (num < 0) {
            throw new customException("음수는 허용 않됩니다.");
        }
        System.out.println("입력값: " + num);
    }
}
// 매개변수 받은 num이 음수라면 customException을 발생시킴