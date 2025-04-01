package stduy.ddd.infrastructure.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import stduy.ddd.domain.question.Question;
import stduy.ddd.domain.question.vo.Title;

public interface SpringDataQuestionRepository extends JpaRepository<Question, Long> {

    Page<Question> findAllByTitleContaining(Pageable pageable, String title);

}
