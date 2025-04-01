package stduy.ddd.infrastructure.user;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import stduy.ddd.domain.user.User;
import stduy.ddd.domain.user.UserRepository;
import stduy.ddd.domain.user.vo.Email;
import stduy.ddd.domain.user.vo.Nickname;

@Repository
@RequiredArgsConstructor
public class JpaUserRepository implements UserRepository {

    private final SpringDataUserRepository repository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        return repository.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(Email email) {
        return repository.existsByEmail(email);
    }

    @Override
    public boolean existsByNickname(Nickname nickname) {
        return repository.existsByNickname(nickname);
    }
}
