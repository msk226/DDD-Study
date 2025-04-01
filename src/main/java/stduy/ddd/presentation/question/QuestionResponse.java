package stduy.ddd.presentation.question;

import com.querydsl.core.annotations.QueryProjection;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import java.time.LocalDateTime;

public class QuestionResponse {

    public record Create(Long questionId) {}
    public record Update(Long questionId) {}

    // 페이징 조회
    public record QuestionSummary
            (Long questionId, String title, String content, String writer, LocalDateTime createdAt, Integer likeCount) {

        @QueryProjection
        public QuestionSummary { }
    };
}
