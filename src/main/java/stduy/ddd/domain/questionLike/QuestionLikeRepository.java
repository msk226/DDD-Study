package stduy.ddd.domain.questionLike;

import java.util.Optional;
import stduy.ddd.domain.question.Question;
import stduy.ddd.domain.user.User;

public interface QuestionLikeRepository {
    QuestionLike save(QuestionLike questionLike);
    void delete(QuestionLike questionLike);
    Optional<QuestionLike> findByUserAndQuestion(User user, Question question);
}
