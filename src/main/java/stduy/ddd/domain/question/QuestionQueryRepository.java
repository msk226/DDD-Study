package stduy.ddd.domain.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import stduy.ddd.presentation.question.QuestionResponse;
import stduy.ddd.presentation.question.QuestionResponse.QuestionSummary;

public interface QuestionQueryRepository {
    Page<QuestionSummary> findAllVisibleByKeyword(Pageable pageable, String keyword);

    QuestionSummary findQuestionDetailById(Long questionId);
}

