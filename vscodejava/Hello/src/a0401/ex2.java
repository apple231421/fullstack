package a0401;

import java.util.Arrays;
import java.util.stream.Stream;

public class ex2 {
    public static void main(String[] args) {
        String[] arr = new String[] { "a", "b", "c", "d", "e", "f" };
        Stream<String> steam1 = Arrays.stream(arr);
        steam1.forEach(s -> System.out.print(s + " "));
        // steam1.forEach(System.out::println);
    }
}
