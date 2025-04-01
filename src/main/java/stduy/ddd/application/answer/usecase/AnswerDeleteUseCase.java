package stduy.ddd.application.answer.usecase;

import stduy.ddd.application.answer.AnswerCommand;

public interface AnswerDeleteUseCase {

    void deleteAnswer(AnswerCommand.Delete command);
}
