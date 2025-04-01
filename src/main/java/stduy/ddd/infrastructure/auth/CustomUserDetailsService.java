package stduy.ddd.infrastructure.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import stduy.ddd.domain.user.User;
import stduy.ddd.domain.user.UserPrincipal;
import stduy.ddd.domain.user.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetails loadUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자 없음"));
        return new UserPrincipal(user.getId(), user.getEmail().getEmail());
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        throw new UnsupportedOperationException("이메일 기반 로그인은 미지원");
    }
}
