package stduy.ddd.domain.user.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Nickname {

    @Column(nullable = false)
    private String value;

    public Nickname(String value) {
        if (value == null || value.length() < 2 || value.length() > 15 || value.matches(".*[!@#$%^&*()].*")) {
            throw new IllegalArgumentException("닉네임은 2~15자의 특수문자 없는 문자열이어야 합니다.");
        }
        this.value = value;
    }

}
