package a0331.sort;

import java.util.Arrays;

public class insertionsort {
    public static void main(String[] args) {
        // 앞에서부터 해당원소가 위치 할 곳을 탐색하고 해당 위치에 삽입
        int[] array = { 63, 34, 25, 17, 22, 11, 90 };
        insertionsort1(array);
        System.out.println("sort array: " + Arrays.toString(array));
    }

    private static void insertionsort1(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i]; // key = 1(인덱스번호) 34
            int j = i - 1; // j = 0(인덱스번호) 63
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
            // 34, 64, 25, 17, 22, 11, 90 i=1일때
            // 34, 64, 25, 17, 22, 11, 90 i=2일때
            // 
        }
    }
}
