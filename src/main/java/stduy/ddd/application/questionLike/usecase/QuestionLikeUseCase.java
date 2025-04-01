package stduy.ddd.application.questionLike.usecase;

import stduy.ddd.application.questionLike.QuestionLikeCommand;
import stduy.ddd.domain.questionLike.QuestionLike;

public interface QuestionLikeUseCase {

    boolean toggleLike(QuestionLikeCommand.Like command);
}
