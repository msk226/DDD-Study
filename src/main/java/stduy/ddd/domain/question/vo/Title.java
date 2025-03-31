package stduy.ddd.domain.question.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Title {

    @Column(nullable = false, length = 50)
    private String value;

    public Title (String title) {
        if (title == null || title.length() > 50) {
            throw new IllegalArgumentException("제목 또는 내용의 형식이 잘못되었습니다.");
        }
        this.value = title;
    }

}
