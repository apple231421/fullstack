package a0318;

import java.util.Arrays;

public class arrEx3 {
    public static void main(String[] args) {
        int[] arrint = new int[5];
        arrint[0] = 1;
        arrint[1] = 2;
        arrint[2] = 3;
        arrint[3] = 4;
        arrint[4] = 5;
        for (int num : arrint) {
            System.out.println(num);
        }
        System.out.println(Arrays.toString(arrint));
    }
}
