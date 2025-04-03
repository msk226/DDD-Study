package stduy.ddd.application.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stduy.ddd.application.answer.AnswerCommand.Delete;
import stduy.ddd.application.answer.usecase.AnswerDeleteUseCase;
import stduy.ddd.common.response.DomainException;
import stduy.ddd.common.response.ErrorCode;
import stduy.ddd.domain.answer.Answer;
import stduy.ddd.domain.answer.AnswerRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class AnswerDeleteService implements AnswerDeleteUseCase {

    private final AnswerRepository answerRepository;

    @Override
    public void deleteAnswer(Delete command) {
        Answer answer = answerRepository.findById(command.answerId())
                .orElseThrow(() -> new DomainException(ErrorCode.ANSWER_NOT_FOUND));

        answer.deleteAnswer(command.userId());
    }
}
