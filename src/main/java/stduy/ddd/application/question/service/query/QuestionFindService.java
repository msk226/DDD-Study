package stduy.ddd.application.question.service.query;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stduy.ddd.application.question.usecase.query.QuestionFindUseCase;
import stduy.ddd.domain.question.repository.QuestionQueryRepository;
import stduy.ddd.presentation.question.QuestionResponse.QuestionSummary;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuestionFindService implements QuestionFindUseCase {

    private final QuestionQueryRepository questionRepository;


    @Override
    public Page<QuestionSummary> getQuestions(Pageable pageable, String keyword) {
        return questionRepository.findAllVisibleByKeyword(pageable, keyword);
    }

    @Override
    public QuestionSummary getQuestion(Long questionId) {
        return questionRepository.findQuestionDetailById(questionId);
    }
}
