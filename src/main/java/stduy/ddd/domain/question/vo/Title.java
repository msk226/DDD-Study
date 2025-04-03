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
public class Title {

    @Column(nullable = false, length = 50)
    private String title;

    public Title (String title) {
        if (title == null || title.length() > 50) {
            throw new DomainException(ErrorCode.CONTENT_FORMAT_ERROR);
        }
        this.title = title;
    }

}
