package stduy.ddd.application.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stduy.ddd.application.user.UserCommand.SignIn;
import stduy.ddd.application.user.usecase.UserSignInUseCase;
import stduy.ddd.common.response.DomainException;
import stduy.ddd.common.response.ErrorCode;
import stduy.ddd.domain.user.User;
import stduy.ddd.domain.user.UserRepository;
import stduy.ddd.domain.user.vo.Email;
import stduy.ddd.infrastructure.auth.JwtTokenProvider;
import stduy.ddd.presentation.user.UserResponse;

@Service
@Transactional
@RequiredArgsConstructor
public class UserSignInService implements UserSignInUseCase {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse.UserSignIn signIn(SignIn command) {
        // 1. 이메일로 유저 조회
        User user = userRepository.findByEmail(new Email(command.email()))
                .orElseThrow(() -> new DomainException(ErrorCode.NOT_EXISTING_USER));

        // 2. 비밀번호 일치 여부 확인
        if (!passwordEncoder.matches(command.password(), user.getPassword().getPassword())) {
            throw new DomainException(ErrorCode.WRONG_PASSWORD);
        }

        // 3. 응답 객체 생성 (토큰 미포함 버전)
        return new UserResponse.UserSignIn(
                user.getId(),
                user.getNickname().getNickname(),
                jwtTokenProvider.generateToken(user.getId())
        );
    }
}
