package stduy.ddd.application.questionLike.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stduy.ddd.application.questionLike.QuestionLikeCommand;
import stduy.ddd.application.questionLike.usecase.QuestionLikeUseCase;
import stduy.ddd.common.response.DomainException;
import stduy.ddd.common.response.ErrorCode;
import stduy.ddd.domain.question.Question;
import stduy.ddd.domain.question.repository.QuestionRepository;
import stduy.ddd.domain.questionLike.QuestionLike;
import stduy.ddd.domain.questionLike.QuestionLikeRepository;
import stduy.ddd.domain.user.User;
import stduy.ddd.domain.user.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionLikeService implements QuestionLikeUseCase {

    private final QuestionLikeRepository questionLikeRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    @Override
    public boolean toggleLike(QuestionLikeCommand.Like command) {

        User user = userRepository.findById(command.userId())
                .orElseThrow(() -> new DomainException(ErrorCode.USER_NOT_FOUND));

        Question question = questionRepository.findById(command.questionId())
                .orElseThrow(() -> new DomainException(ErrorCode.QUESTION_NOT_FOUND));

        Optional<QuestionLike> like = questionLikeRepository.findByUserAndQuestion(user, question);

        if (like.isPresent()) {
            questionLikeRepository.delete(like.get()); // 좋아요 취소
            return false;
        } else {
            QuestionLike newLike = QuestionLike.of(user, question);
            questionLikeRepository.save(newLike); // 좋아요 등록
            return true;
        }
    }
}
