package stduy.ddd.domain.question.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Content {

    @Column(nullable = false, length = 300)
    private String content;

    public Content (String content) {
        if (content == null || content.length() > 300) {
            throw new IllegalArgumentException("제목 또는 내용의 형식이 잘못되었습니다.");
        }
        this.content = content;
    }
}
