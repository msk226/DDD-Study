package stduy.ddd.application.question.usecase;

import stduy.ddd.application.question.QuestionCommand;

public interface QuestionDeleteUseCase {

    void deleteQuestion(QuestionCommand.Delete command);
}
