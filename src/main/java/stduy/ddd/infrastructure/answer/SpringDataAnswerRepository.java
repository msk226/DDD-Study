package stduy.ddd.infrastructure.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import stduy.ddd.domain.answer.Answer;


public interface SpringDataAnswerRepository extends JpaRepository<Answer, Long> {
}
