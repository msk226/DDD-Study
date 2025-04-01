package stduy.ddd.domain.question;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import stduy.ddd.presentation.question.QuestionResponse;

public interface QuestionRepository {

    Question save(Question question);
    Optional<Question> findById(Long id);
}
