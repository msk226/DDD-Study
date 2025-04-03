package stduy.ddd.domain.answer;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import stduy.ddd.common.response.DomainException;
import stduy.ddd.common.response.ErrorCode;
import stduy.ddd.domain.answer.vo.Content;
import stduy.ddd.domain.question.Question;
import stduy.ddd.domain.question.vo.Title;
import stduy.ddd.domain.user.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Answer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Content content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User writer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    private boolean isDeleted;

    private LocalDateTime createdAt;

    private Answer(Content content, User writer, Question question) {
        this.content = content;
        this.writer = writer;
        this.question = question;
        this.isDeleted = false;
        this.createdAt = LocalDateTime.now();
    }

    public static Answer of(Content content, User writer, Question question) {
        return new Answer(content, writer, question);
    }

    public void validateWriter(Long currentUserId) {
        if (!this.writer.getId().equals(currentUserId)) {
            throw new DomainException(ErrorCode.FORBIDDEN);
        }
    }

    public void updateContent(Content content, Long currentUserId) {
        validateWriter(currentUserId);
        this.content = content;
    }

    public void deleteAnswer(Long currentUserId) {
        validateWriter(currentUserId);

        if (this.isDeleted) {
            throw new DomainException(ErrorCode.ANSWER_NOT_FOUND);
        }

        this.isDeleted = true;
    }

}
