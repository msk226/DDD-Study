package stduy.ddd.domain.user.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import stduy.ddd.common.response.DomainException;
import stduy.ddd.common.response.ErrorCode;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Password {

    @Column(nullable = false)
    private String password;

    public Password (String password, PasswordEncoder encoder) {
        if (password.length() < 8 || !password.matches(".*[!@#$%^&*()].*")) {
            throw new DomainException(ErrorCode.INVALID_PASSWORD);
        }

        this.password = encoder.encode(password);
    }
}
