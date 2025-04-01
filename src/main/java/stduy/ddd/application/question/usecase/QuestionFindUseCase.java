package stduy.ddd.application.question.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import stduy.ddd.presentation.question.QuestionResponse;
import stduy.ddd.presentation.question.QuestionResponse.QuestionSummary;

public interface QuestionFindUseCase {

    Page<QuestionSummary> getQuestions(Pageable pageable, String keyword);

}
