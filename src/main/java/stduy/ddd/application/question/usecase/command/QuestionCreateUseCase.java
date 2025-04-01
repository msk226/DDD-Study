package stduy.ddd.application.question.usecase.command;

import stduy.ddd.application.question.QuestionCommand.Create;

public interface QuestionCreateUseCase {

    Long createQuestion(Create command, Long userId);
}
