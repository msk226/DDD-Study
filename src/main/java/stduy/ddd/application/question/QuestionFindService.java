package stduy.ddd.application.question;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stduy.ddd.application.question.usecase.QuestionFindUseCase;
import stduy.ddd.domain.question.QuestionQueryRepository;
import stduy.ddd.domain.question.QuestionRepository;
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
}
