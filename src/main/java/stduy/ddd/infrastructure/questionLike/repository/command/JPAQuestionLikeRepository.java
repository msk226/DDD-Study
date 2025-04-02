package stduy.ddd.infrastructure.questionLike.repository.command;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import stduy.ddd.domain.question.Question;
import stduy.ddd.domain.questionLike.QuestionLike;
import stduy.ddd.domain.questionLike.QuestionLikeRepository;
import stduy.ddd.domain.user.User;

@Repository
@RequiredArgsConstructor
public class JPAQuestionLikeRepository implements QuestionLikeRepository {

    private final SpringDataQuestionLikeRepository repository;

    @Override
    public QuestionLike save(QuestionLike questionLike) {
        return repository.save(questionLike);
    }

    @Override
    public void delete(QuestionLike questionLike) {
        repository.delete(questionLike);
    }

    @Override
    public Optional<QuestionLike> findByUserAndQuestion(User user, Question question) {
        return repository.findByUserAndQuestion(user, question);
    }
}
