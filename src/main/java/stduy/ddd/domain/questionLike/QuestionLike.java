package stduy.ddd.domain.questionLike;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import stduy.ddd.domain.question.Question;
import stduy.ddd.domain.user.User;

@Entity
@Table (
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id, question_id"})
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionLike {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    private LocalDateTime createdAt;

    private QuestionLike(User user, Question question) {
        this.user = user;
        this.question = question;
        this.createdAt = LocalDateTime.now();
    }

    // 정적 팩토리 메서드
    public static QuestionLike of(User user, Question question) {
        return new QuestionLike(user, question);
    }





}
