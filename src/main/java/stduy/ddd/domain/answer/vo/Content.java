package stduy.ddd.domain.answer.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Content {

    @Column(name = "content")
    private String value;

    public Content(String value) {
        if (value == null || value.length() > 50) {
            throw new IllegalArgumentException("제목 또는 내용의 형식이 잘못되었습니다.");
        }
        this.value = value;
    }
}
