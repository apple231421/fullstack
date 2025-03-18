package a0318;

public class factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorial(3));
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
// factorial(5) = 5 * factorial(5-1) 
// factorial(4) = 4 * factorial(4-1) 
// factorial(3) = 3 * factorial(3-1) 
// factorial(2) = 2 * factorial(2-1) 
// factorial(1) = 1 * factorial(1-1) 

// factorial(1) = 1
// factorial(2) = 2*1
// factorial(3) = 3*2*1
// factorial(4) = 4*3*2*1
// factorial(5) = 5*4*3*2*1