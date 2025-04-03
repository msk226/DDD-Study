package stduy.ddd.domain.question.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import stduy.ddd.common.response.DomainException;
import stduy.ddd.common.response.ErrorCode;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Content {

    @Column(nullable = false, length = 300)
    private String content;

    public Content (String content) {
        if (content == null || content.length() > 300) {
            throw new DomainException(ErrorCode.CONTENT_FORMAT_ERROR);
        }
        this.content = content;
    }
}
