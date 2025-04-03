package stduy.ddd.application.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stduy.ddd.application.answer.AnswerCommand.Update;
import stduy.ddd.application.answer.usecase.AnswerUpdateUseCase;
import stduy.ddd.common.response.DomainException;
import stduy.ddd.common.response.ErrorCode;
import stduy.ddd.domain.answer.Answer;
import stduy.ddd.domain.answer.AnswerRepository;
import stduy.ddd.domain.answer.vo.Content;

@Service
@Transactional
@RequiredArgsConstructor
public class AnswerUpdateService implements AnswerUpdateUseCase {

    private final AnswerRepository answerRepository;

    @Override
    public Long updateAnswer(Update command) {
        Answer answer = answerRepository.findById(command.answerId())
                .orElseThrow(() -> new DomainException(ErrorCode.ANSWER_NOT_FOUND));

        answer.updateContent(new Content(command.content()), command.userId());
        return answerRepository.save(answer).getId();
    }
}
