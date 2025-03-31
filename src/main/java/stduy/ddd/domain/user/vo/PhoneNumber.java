package stduy.ddd.domain.user.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PhoneNumber {

    @Column(nullable = false, unique = true, length = 11)
    private String phoneNumber;

    public PhoneNumber (String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("^\\d{10,11}$")) {
            throw new IllegalArgumentException("전화번호는 10~11자리 숫자만 입력 가능합니다.");
        }
        this.phoneNumber = phoneNumber;
    }
}
