package stduy.ddd.infrastructure.user;

import org.springframework.data.jpa.repository.JpaRepository;
import stduy.ddd.domain.user.User;
import stduy.ddd.domain.user.vo.Email;
import stduy.ddd.domain.user.vo.Nickname;

public interface SpringDataUserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(Email email);
    boolean existsByNickname(Nickname nickname);
}
