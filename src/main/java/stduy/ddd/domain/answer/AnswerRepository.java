package stduy.ddd.domain.answer;

import java.util.Optional;

public interface AnswerRepository {

    Answer save(Answer answer);
    Optional<Answer> findById(Long answerId);
}
