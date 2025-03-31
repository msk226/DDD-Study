package stduy.ddd.application.usecase;

import stduy.ddd.application.QuestionCommand;

public interface QuestionCreateUseCase {

    Long createQuestion(QuestionCommand.create command, Long userId);
}
