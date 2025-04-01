package stduy.ddd.application.answer.usecase;

import stduy.ddd.application.answer.AnswerCommand;

public interface AnswerUpdateUseCase {

    Long updateAnswer(AnswerCommand.Update command);
}
