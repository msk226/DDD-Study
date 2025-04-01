package stduy.ddd.infrastructure.questionLike;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import stduy.ddd.domain.question.Question;
import stduy.ddd.domain.questionLike.QuestionLike;
import stduy.ddd.domain.user.User;

public interface SpringDataQuestionLikeRepository extends JpaRepository<QuestionLike, Long> {
    Optional<QuestionLike> findByUserAndQuestion(User user, Question question);

}
