package stduy.ddd.domain.user.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import stduy.ddd.common.response.DomainException;
import stduy.ddd.common.response.ErrorCode;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Email {

    @Column(nullable = false, unique = true)
    private String email;

    public Email (String email) {
        if (!email.matches("^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
            throw new DomainException(ErrorCode.INVALID_EMAIL);
        }
        this.email = email;
    }
}
