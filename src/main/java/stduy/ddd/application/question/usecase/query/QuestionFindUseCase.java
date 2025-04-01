package stduy.ddd.application.question.usecase.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import stduy.ddd.presentation.question.QuestionResponse.QuestionSummary;

public interface QuestionFindUseCase {

    Page<QuestionSummary> getQuestions(Pageable pageable, String keyword);

    QuestionSummary getQuestion(Long questionId);

}
