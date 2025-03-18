package a0318;

public class arrEx2 {
    public static void main(String[] args) {
        int[] arrint = new int[5]; // 길이가 5개인 배열 객체생성

        System.out.println(arrint[0]);
        for (int i = 0; i < arrint.length; i++) {
            System.out.println(arrint[i]);
        }
        for (int num : arrint) {
            System.out.println(num);
        }
    }
}
