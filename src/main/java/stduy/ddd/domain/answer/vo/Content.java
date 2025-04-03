package stduy.ddd.domain.answer.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import stduy.ddd.common.response.DomainException;
import stduy.ddd.common.response.ErrorCode;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Content {

    @Column(name = "content")
    private String value;

    public Content(String value) {
        if (value == null || value.length() > 50) {
            throw new DomainException(ErrorCode.CONTENT_FORMAT_ERROR);
        }
        this.value = value;
    }
}
