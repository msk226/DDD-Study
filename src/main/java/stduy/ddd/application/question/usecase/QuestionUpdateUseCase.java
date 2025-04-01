package stduy.ddd.application.question.usecase;

import stduy.ddd.application.question.QuestionCommand;

public interface QuestionUpdateUseCase {

    Long updateQuestion(QuestionCommand.Update command, Long userId);
}
