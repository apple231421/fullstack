package a0313;

public class Ari2 {
    public static void main(String[] args) {
        double cm = 176.6;
        double kg = 74.34;
        System.out.printf("키 : %.1fcm\n",cm);
        System.out.printf("몸무게 : %.1fkg\n",kg);

        System.out.printf("키 : %dcm\n",(int)cm);
        System.out.printf("몸무게 : %dkg\n",(int)kg);
        // 다운캐스팅
    }
}
