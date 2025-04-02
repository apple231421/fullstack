package a0402.optional;

import java.util.Optional;
// 값이 존재하면 작업수행(ifPresent)
public class Optional3 {
    public static void main(String[] args) {
        Optional<String> name = Optional.of("charlie");

        // 값이 있으면 동작을 수행
        name.ifPresent(n-> System.out.println("hello, "+n));


        Optional<String> name1 = Optional.ofNullable(null);
        String result1 = name1.orElse("guest");
        System.out.println("hello " + result1);
    }
}
