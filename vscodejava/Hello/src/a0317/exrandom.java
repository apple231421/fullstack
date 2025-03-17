package a0317;

public class exrandom {
    public static void main(String[] args) {
        while (true) { 
            int a = (int) (Math.random() * 7); 
            int b = (int) (Math.random() * 7);
            int sum = a + b;
            System.out.println("(" + a + "," + b + ")");
            
            if (sum == 5) {
                break; // Exit loop when sum is 5
            }
        }
    }
}
