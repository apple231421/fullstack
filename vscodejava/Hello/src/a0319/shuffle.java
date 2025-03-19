package a0319;

import java.util.Arrays;

public class shuffle {
    public static void main(String[] args) {
        int[] numarr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // for (int i = 0; i < numarr.length; i++) {
        // // System.out.println(numarr[i]);
        // System.out.print(numarr[i] + " ");
        // }
        // for(int num : numarr){
        // System.out.println(num);
        // }
        // System.out.println(Arrays.toString(numarr));


        // 100번 돌아감
        for (int i = 0; i < 100; i++) {
            int n = (int) (Math.random() * 10); // 0~9까지

            
            int tmp = numarr[0];
            numarr[0] = numarr[n];
            numarr[n] = tmp;
        }
        System.out.println(Arrays.toString(numarr));
    }
}
