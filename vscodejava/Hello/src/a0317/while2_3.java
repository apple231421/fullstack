package a0317;

public class while2_3 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        int endnum = 10;
        while(i<=endnum){
            
            sum = sum + i;
            System.out.println("i=" + i + " sum=" + sum);
            i++;
        }
    }
}
