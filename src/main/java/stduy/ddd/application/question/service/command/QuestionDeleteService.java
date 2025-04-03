package stduy.ddd.application.question.service.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stduy.ddd.application.question.QuestionCommand;
import stduy.ddd.application.question.usecase.command.QuestionDeleteUseCase;
import stduy.ddd.common.response.DomainException;
import stduy.ddd.common.response.ErrorCode;
import stduy.ddd.domain.question.Question;
import stduy.ddd.domain.question.repository.QuestionRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionDeleteService implements QuestionDeleteUseCase {

    private final QuestionRepository questionRepository;

    @Override
    public void deleteQuestion(QuestionCommand.Delete command) {
        Question question = questionRepository.findById(command.questionId())
                .orElseThrow(() ->new DomainException(ErrorCode.QUESTION_NOT_FOUND));

        question.delete(command.userId());
    }
}
