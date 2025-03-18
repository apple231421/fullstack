package a0318;

import java.util.Arrays;

public class arr3_1 {
    public static void main(String[] args) {
        int[] iarr1 = new int[10];
        int[] iarr2 = new int[10];
        int[] iarr3 = { 100, 95, 80, 70, 60 };
        char[] charr = { 'a', 'b', 'c', 'd', 'e' };
        // for문을 돌려서 iarr1 에 1,2,3,4,5,6,7,8,9,10 들어가도록해주세요

        for (int i = 0; i < iarr1.length; i++) {
            iarr1[i] = i + 1;
        }
        System.out.println(Arrays.toString(iarr1));
        System.out.println();

        for (int k = 0; k < iarr1.length; k++) {
            iarr2[k] = (int) (Math.random() * 10) + 1;
        }
        System.out.println(Arrays.toString(iarr2));
        System.out.println();

        System.out.println(iarr3);
        // 참조변수

        System.out.println(charr);
        // println 메서드가 char 배열일때만 이렇게 동작하도록 작성됨
    }
}
