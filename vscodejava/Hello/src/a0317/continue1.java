package a0317;

public class continue1 {
    // 1부터 시작해서 숫자를 계속 누적해서 더하다가 합계가 10보다 처음으로 큰값
    public static void main(String[] args) {
        
        int i = 1;
        while (i<=5) {
            if(i==3){
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }
    }
    // 조건식을 보면 true라고 되있음 조건이 항상 참이기 때문에 이렇게 두면
    // while은 무한반복된다. break 문이 있어 중간에 빠져나올수 있다.
    // 만약 sum > 10 조건에  만족하면 결과출력후 , break를 사용해서
    //while문을 빠져나간다
}
