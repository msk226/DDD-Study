package stduy.ddd.application.answer;

public class AnswerCommand {

    public record Create(String content, Long userId, Long questionId){}
}
