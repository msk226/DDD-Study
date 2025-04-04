package stduy.ddd.application.answer;

public class AnswerCommand {

    public record Create(String content, Long userId, Long questionId){}
    public record Update(String content, Long userId, Long answerId){}
    public record Delete(Long userId, Long answerId) {}
}
