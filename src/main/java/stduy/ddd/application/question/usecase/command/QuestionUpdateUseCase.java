package stduy.ddd.application.question.usecase.command;

import stduy.ddd.application.question.QuestionCommand;

public interface QuestionUpdateUseCase {

    Long updateQuestion(QuestionCommand.Update command, Long userId);
}
