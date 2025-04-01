package stduy.ddd.domain.question;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionRepository {

    Question save(Question question);
    Optional<Question> findById(Long id);
    Page<Question> findAllWithCondition(Pageable pageable, String keyword);
}
