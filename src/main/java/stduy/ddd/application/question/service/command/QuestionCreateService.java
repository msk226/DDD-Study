package stduy.ddd.application.question.service.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stduy.ddd.application.question.QuestionCommand.Create;
import stduy.ddd.application.question.usecase.command.QuestionCreateUseCase;
import stduy.ddd.domain.question.Question;
import stduy.ddd.domain.question.QuestionRepository;
import stduy.ddd.domain.question.vo.Content;
import stduy.ddd.domain.question.vo.Title;
import stduy.ddd.domain.user.User;
import stduy.ddd.domain.user.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionCreateService implements QuestionCreateUseCase {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    @Override
    public Long createQuestion(Create command, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재 하지 않는 회원입니다."));

        Question question = Question.create(
                new Title(command.title()),
                new Content(command.content()),
                user
        );

        return questionRepository.save(question).getId();
    }
}
