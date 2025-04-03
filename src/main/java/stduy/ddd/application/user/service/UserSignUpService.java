package stduy.ddd.application.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stduy.ddd.application.user.UserCommand.SignUp;
import stduy.ddd.application.user.usecase.UserSignUpUseCase;
import stduy.ddd.common.response.DomainException;
import stduy.ddd.common.response.ErrorCode;
import stduy.ddd.domain.user.User;
import stduy.ddd.domain.user.UserRepository;
import stduy.ddd.domain.user.vo.Email;
import stduy.ddd.domain.user.vo.Nickname;
import stduy.ddd.domain.user.vo.Password;
import stduy.ddd.domain.user.vo.PhoneNumber;

@Service
@Transactional
@RequiredArgsConstructor
public class UserSignUpService implements UserSignUpUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Long create(SignUp command) {
        Email email = new Email(command.email());

        if (userRepository.existsByEmail(email)) {
            throw new DomainException(ErrorCode.ALREADY_USING_EMAIL);
        }

        Nickname nickname = new Nickname(command.nickname());

        if (userRepository.existsByNickname(nickname)) {
            throw new DomainException(ErrorCode.ALREADY_USING_NICKNAME);
        }

        Password password = new Password(command.password(), passwordEncoder);
        PhoneNumber phoneNumber = new PhoneNumber(command.phoneNumber());

        User user = User.create(email, password, nickname, phoneNumber, command.name());

        return userRepository.save(user).getId();
    }
}
