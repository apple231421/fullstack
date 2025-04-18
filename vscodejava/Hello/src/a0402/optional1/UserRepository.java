package a0402.optional1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User(1L, "Alice"));
        users.add(new User(2L, "Bob"));
        users.add(new User(3L, "Charlie"));
    }

    public Optional<User> findById(long id) {
        // for (User user : users) {// users 리스트를 순회하면서
        // if (user.getId().equals(id)) {
        // return Optional.of(user);
        // }
        // }
        // return Optional.empty(); // 없으면 빈 Optional 반환

        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
        // .findFirst; 첫번째 조건을 만족하는 객체를 Optional<T> 감싸서 반환 (T = 타입)
        // 없으면 알아서 Optional.empty()
    }
}
