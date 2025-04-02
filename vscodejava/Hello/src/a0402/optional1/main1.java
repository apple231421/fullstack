package a0402.optional1;

import java.util.Optional;

public class main1 {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        // 존재하는 ID로 검색
        Optional<User> UserOptional = userRepository.findById(2L);
        UserOptional.ifPresentOrElse(user -> System.out.println("찾는 사용자: " + user),
                () -> System.out.println("찾으시는 사용자가 없습니다")); // ifPresentOrElse(값이 있는거, 값이 없는거)

        Optional<User> UserOptional2 = userRepository.findById(99L);
        UserOptional2.ifPresentOrElse(user -> System.out.println("찾는 사용자: " + user),
                () -> System.out.println("찾으시는 사용자가 없습니다")); // ifPresentOrElse(값이 있는거, 값이 없는거)

        Optional<User> UserOptional3 = userRepository.findById(2L);
        UserOptional3.ifPresentOrElse(user -> System.out.println("찾는 사용자: " + user),
                () -> System.out.println("찾으시는 사용자가 없습니다")); // ifPresentOrElse(값이 있는거, 값이 없는거)

        // 기본값 제공
        User defaultUser = UserOptional3.orElse(new User(0L, "기본유저"));
        System.out.println("기본 사용자 : " + defaultUser);
    }
}
// findById 메서드
// 아이디로 사용자 리스트 검색 결과 optional<user>반환
// optional.empty 는 사용가 없을떄 반환
// optional처리방식
// ifPresentOrElse:값이 없으면 기본값 반환
// orelsethrow 값이 없으면 예외를 던질수 있음