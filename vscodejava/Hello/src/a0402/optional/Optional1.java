package a0402.optional;

import java.util.Optional;

// Optional null값으로 인한 문제 방지, 안전하게 값을 처리
// Optional 은 null 이 될 수 있는 객체를 감싸는 래퍼클래스
public class Optional1 {
    public static void main(String[] args) {

        Optional<String> name = Optional.of("john");
        System.out.println("name 은 " + name.get());

        // Optional.empty(); 빈 optional 생성
        Optional<String> emptyname = Optional.empty();
        System.out.println("emptyname 은 " + emptyname.isPresent()); // false

        // 3.Optional.ofNullable() = null을 허용하는 Optional 생성

        Optional<String> nullablename = Optional.ofNullable(null);
        System.out.println("Is empty :  " + nullablename.isPresent()); // false
    }
}
