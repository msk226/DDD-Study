package stduy.ddd.application.answer.usecase;

import stduy.ddd.application.answer.AnswerCommand;

public interface AnswerCreateUseCase {

    Long createAnswer(AnswerCommand.Create command);
}
