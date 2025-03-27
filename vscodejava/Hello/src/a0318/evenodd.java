package a0318;



public class evenodd {
    public static void main(String[] args) {
        System.out.println(evenodd(4));
        System.out.println(evenodd(7));
    }

    private static String evenodd(int num) {
        return (num % 2 ==0) ? "even" : "odd";
    }
}
