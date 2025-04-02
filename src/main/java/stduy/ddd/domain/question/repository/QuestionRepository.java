package stduy.ddd.domain.question.repository;

import java.util.Optional;
import stduy.ddd.domain.question.Question;

public interface QuestionRepository {

    Question save(Question question);
    Optional<Question> findById(Long id);
}
