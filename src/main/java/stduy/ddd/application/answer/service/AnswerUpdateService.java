package stduy.ddd.application.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stduy.ddd.application.answer.AnswerCommand.Update;
import stduy.ddd.application.answer.usecase.AnswerUpdateUseCase;
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
                .orElseThrow(() -> new IllegalArgumentException("존재 하지 않는 답변입니다."));

        answer.updateContent(new Content(command.content()), command.userId());
        return answerRepository.save(answer).getId();
    }
}
