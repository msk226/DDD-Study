package stduy.ddd.application.question.usecase;

import stduy.ddd.application.question.QuestionCommand;

public interface QuestionCreateUseCase {

    Long createQuestion(QuestionCommand.create command, Long userId);
}
