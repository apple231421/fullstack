package a0403.stream;

import java.util.stream.Stream;

public class stream5 {
    public static void main(String[] args) {
        Stream<Double> stream = Stream.of(4.2, 2.5, 3.1, 1.5);
        stream.forEach(System.out::println);
    }
}
