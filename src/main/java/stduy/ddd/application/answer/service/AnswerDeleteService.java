package stduy.ddd.application.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stduy.ddd.application.answer.AnswerCommand.Delete;
import stduy.ddd.application.answer.usecase.AnswerDeleteUseCase;
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
                .orElseThrow(() -> new IllegalArgumentException("존재 하지 않는 답변입니다."));

        answer.deleteAnswer(command.userId());
    }
}
