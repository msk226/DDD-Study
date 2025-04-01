package stduy.ddd.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stduy.ddd.application.user.usecase.UserSignInUseCase;
import stduy.ddd.domain.user.User;
import stduy.ddd.domain.user.UserRepository;
import stduy.ddd.domain.user.vo.Email;
import stduy.ddd.presentation.user.UserResponse;
import stduy.ddd.presentation.user.UserResponse.UserSignIn;

@Service
@Transactional
@RequiredArgsConstructor
public class UserSignInService implements UserSignInUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse.UserSignIn signIn(String email, String rawPassword) {
        // 1. 이메일로 유저 조회
        User user = userRepository.findByEmail(new Email(email))
                .orElseThrow(() -> new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다."));

        // 2. 비밀번호 일치 여부 확인
        if (!passwordEncoder.matches(rawPassword, user.getPassword().getPassword())) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다.");
        }

        // 3. 응답 객체 생성 (토큰 미포함 버전)
        return new UserResponse.UserSignIn(
                user.getId(),
                user.getNickname().getNickname()
        );
    }
}
