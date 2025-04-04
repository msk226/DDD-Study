package stduy.ddd.application.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stduy.ddd.application.answer.AnswerCommand.Create;
import stduy.ddd.application.answer.usecase.AnswerCreateUseCase;
import stduy.ddd.common.response.DomainException;
import stduy.ddd.common.response.ErrorCode;
import stduy.ddd.domain.answer.Answer;
import stduy.ddd.domain.answer.AnswerRepository;
import stduy.ddd.domain.answer.vo.Content;
import stduy.ddd.domain.question.Question;
import stduy.ddd.domain.question.repository.QuestionRepository;
import stduy.ddd.domain.user.User;
import stduy.ddd.domain.user.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class AnswerCreateService implements AnswerCreateUseCase {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    @Override
    public Long createAnswer(Create command) {

        User writer = userRepository.findById(command.userId())
                .orElseThrow(() -> new DomainException(ErrorCode.USER_NOT_FOUND));

        Question question = questionRepository.findById(command.questionId())
                .orElseThrow(() -> new DomainException(ErrorCode.QUESTION_NOT_FOUND));

        Answer answer = Answer.of(new Content(command.content()), writer, question);

        return answerRepository.save(answer).getId();
    }
}
