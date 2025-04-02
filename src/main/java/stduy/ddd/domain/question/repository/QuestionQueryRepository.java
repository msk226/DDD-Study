package stduy.ddd.domain.question.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import stduy.ddd.presentation.question.QuestionResponse.QuestionSummary;

public interface QuestionQueryRepository {
    Page<QuestionSummary> findAllVisibleByKeyword(Pageable pageable, String keyword);

    QuestionSummary findQuestionDetailById(Long questionId);
}

