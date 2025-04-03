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
public class PhoneNumber {

    @Column(nullable = false, unique = true, length = 11)
    private String phoneNumber;

    public PhoneNumber (String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("^\\d{10,11}$")) {
            throw new DomainException(ErrorCode.INVALID_PHONE_NUMBER);
        }
        this.phoneNumber = phoneNumber;
    }
}
