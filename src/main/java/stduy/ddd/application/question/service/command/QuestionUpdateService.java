package stduy.ddd.application.question.service.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stduy.ddd.application.question.QuestionCommand.Update;
import stduy.ddd.application.question.usecase.command.QuestionUpdateUseCase;
import stduy.ddd.common.response.DomainException;
import stduy.ddd.common.response.ErrorCode;
import stduy.ddd.domain.question.Question;
import stduy.ddd.domain.question.repository.QuestionRepository;
import stduy.ddd.domain.question.vo.Content;
import stduy.ddd.domain.question.vo.Title;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionUpdateService implements QuestionUpdateUseCase {

    private final QuestionRepository questionRepository;

    @Override
    public Long updateQuestion(Update command, Long userId) {
        Question question = questionRepository.findById(command.questionId())
                .orElseThrow(() -> new DomainException(ErrorCode.QUESTION_NOT_FOUND));

        question.validateWriter(userId);

        question.updateQuestion(new Title(command.title()), new Content(command.content()));

        return questionRepository.save(question).getId();
    }
}
