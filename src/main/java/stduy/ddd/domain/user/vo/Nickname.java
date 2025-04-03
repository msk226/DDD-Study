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
public class Nickname {

    @Column(nullable = false)
    private String nickname;

    public Nickname(String value) {
        if (value == null || value.length() < 2 || value.length() > 15 || value.matches(".*[!@#$%^&*()].*")) {
            throw new DomainException(ErrorCode.INVALID_NICKNAME);
        }
        this.nickname = value;
    }

}
