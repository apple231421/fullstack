package a0313;

public class Ari1 {

    public static void main(String[] args) {
        byte v1 = 10;
        byte v2 = 4;
        int v3 = 5;
        long v4 = 10L;

        int result1 = v1 + v2;
        System.out.println(result1);

        int result3 = v1 / v2;
        System.out.println("result : " + result3);

        double result4 = v1 / (double)v2;
        //double 타입으로 강제 타입변환
        System.out.println("result : " + result4);

        double result5 = 10 /4;
        System.out.println(result5);

        double result6 = 10 /(double)4;
        System.out.println(result6);
    }
}