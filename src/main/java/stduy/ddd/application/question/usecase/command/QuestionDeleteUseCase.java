package stduy.ddd.application.question.usecase.command;

import stduy.ddd.application.question.QuestionCommand;

public interface QuestionDeleteUseCase {

    void deleteQuestion(QuestionCommand.Delete command);
}
