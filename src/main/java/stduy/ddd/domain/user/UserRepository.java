package stduy.ddd.domain.user;

import stduy.ddd.domain.user.vo.Email;
import stduy.ddd.domain.user.vo.Nickname;

public interface UserRepository {
    User save(User user);

    boolean existsByEmail(Email email);
    boolean existsByNickname(Nickname nickname);
}
