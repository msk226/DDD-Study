package stduy.ddd.infrastructure.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import stduy.ddd.domain.user.User;
import stduy.ddd.domain.user.vo.Email;
import stduy.ddd.domain.user.vo.Nickname;

public interface SpringDataUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(Email email);
    Optional<User> findById(Long id);
    boolean existsByEmail(Email email);
    boolean existsByNickname(Nickname nickname);
}
