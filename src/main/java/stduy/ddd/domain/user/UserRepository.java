package stduy.ddd.domain.user;

import java.util.Optional;
import stduy.ddd.domain.user.vo.Email;
import stduy.ddd.domain.user.vo.Nickname;

public interface UserRepository {
    User save(User user);
    Optional<User> findByEmail(Email email);
    Optional<User> findById(Long id);

    boolean existsByEmail(Email email);
    boolean existsByNickname(Nickname nickname);
}
