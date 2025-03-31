package stduy.ddd.domain.question;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import stduy.ddd.domain.question.vo.Content;
import stduy.ddd.domain.question.vo.Title;
import stduy.ddd.domain.user.User;

@Entity
@Getter
@NoArgsConstructor
public class Question {

    @Id
    private Long id;

    @Embedded
    private Title title;

    @Embedded
    private Content content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User writer;

    private boolean isDeleted;

    private LocalDateTime createdAt;


    // 정적 팩토리 메서드
    public static Question create(Title title, Content content, User writer) {
        Question question = new Question();
        question.title = title;
        question.content = content;
        question.writer = writer;
        question.isDeleted = false;
        question.createdAt = LocalDateTime.now();
        return question;
    }
}
