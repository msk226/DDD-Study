package stduy.ddd.infrastructure.answer.repository.command;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import stduy.ddd.domain.answer.Answer;
import stduy.ddd.domain.answer.AnswerRepository;

@Repository
@RequiredArgsConstructor
public class JPAAnswerRepository implements AnswerRepository {

    private final SpringDataAnswerRepository repository;

    @Override
    public Answer save(Answer answer) {
        return repository.save(answer);
    }

    @Override
    public Optional<Answer> findById(Long answerId) {
        return repository.findById(answerId);
    }
}
