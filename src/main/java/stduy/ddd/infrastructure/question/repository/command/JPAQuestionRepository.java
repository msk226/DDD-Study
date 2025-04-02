package stduy.ddd.infrastructure.question.repository.command;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import stduy.ddd.domain.question.Question;
import stduy.ddd.domain.question.repository.QuestionRepository;

@Repository
@RequiredArgsConstructor
public class JPAQuestionRepository implements QuestionRepository {

    private final SpringDataQuestionRepository repository;

    @Override
    public Question save(Question question) {
        return repository.save(question);
    }

    @Override
    public Optional<Question> findById(Long id) {
        return repository.findById(id);
    }
}