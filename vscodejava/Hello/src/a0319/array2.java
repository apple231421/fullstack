package a0319;

public class array2 {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4, 5 }, // [0][4] = 5 앞이 행번호 뒤가 행 안에서 인덱스 번호
                { 6, 7, 8, 9, 0 }, // [1][3] = 9
                { 10, 20, 30, 40, 50 } // [2][2] = 30
        };
        System.out.println(arr[0][4] + arr[1][3] + arr[2][2]);
    }
}
