package a0318;

public class randomnumber {
    public static void main(String[] args) {
        int n = rolldie();
        System.out.printf("주사위의 눈: %d", n);
    }

    private static int rolldie() {
        // int x = (int) (6 * Math.random() + 1);
        // return x;
        
        double x = 6 * Math.random();
        int temp = (int) x;
        return temp + 1;
    }
}
