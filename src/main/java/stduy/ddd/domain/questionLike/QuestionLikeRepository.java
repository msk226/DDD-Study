package stduy.ddd.domain.questionLike;

import java.util.Optional;
import stduy.ddd.domain.question.Question;
import stduy.ddd.domain.user.User;

public interface QuestionLikeRepository {
    Optional<QuestionLike> findByUserAndQuestion(User user, Question question);
}
