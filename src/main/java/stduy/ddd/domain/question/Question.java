package stduy.ddd.domain.question;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Title title;

    @Embedded
    private Content content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
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

    public void validateWriter(Long userId) {
        if (!this.writer.getId().equals(userId)) {
            throw new IllegalArgumentException("해당 질문을 수정할 권한이 없습니다.");
        }
    }
    public void updateQuestion(Title title, Content content) {
        this.title = title;
        this.content = content;
    }

    public void delete(Long currentUserId) {
        validateWriter(currentUserId);

        if (this.isDeleted) {
            throw new IllegalArgumentException("이미 삭제 처리 된 질문입니다.");
        }
        this.isDeleted = true;
    }
}
