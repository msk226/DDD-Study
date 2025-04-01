package stduy.ddd.application.question.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stduy.ddd.application.question.QuestionCommand.Update;
import stduy.ddd.domain.question.Question;
import stduy.ddd.domain.question.QuestionRepository;
import stduy.ddd.domain.question.vo.Content;
import stduy.ddd.domain.question.vo.Title;
import stduy.ddd.domain.user.User;
import stduy.ddd.domain.user.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionUpdateService implements QuestionUpdateUseCase{

    private final QuestionRepository questionRepository;

    @Override
    public Long updateQuestion(Update command, Long userId) {
        Question question = questionRepository.findById(command.questionId())
                .orElseThrow(() -> new IllegalArgumentException("질문이 존재하지 않습니다."));

        question.validateWriter(userId);

        question.updateQuestion(new Title(command.title()), new Content(command.content()));

        return questionRepository.save(question).getId();
    }
}
