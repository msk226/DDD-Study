package stduy.ddd.application.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stduy.ddd.application.question.usecase.QuestionDeleteUseCase;
import stduy.ddd.domain.question.Question;
import stduy.ddd.domain.question.QuestionRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionDeleteService implements QuestionDeleteUseCase {

    private final QuestionRepository questionRepository;

    @Override
    public void deleteQuestion(Long questionId, Long userId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new IllegalArgumentException("질문이 존재하지 않습니다."));

        question.delete(userId);
    }
}
