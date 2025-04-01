package stduy.ddd.infrastructure.answer;

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
}
