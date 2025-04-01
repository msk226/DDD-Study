package stduy.ddd.application.question;

public class QuestionCommand {

    public record Create(String title, String content) {}

    public record Update(Long questionId, String title, String content) {}

    public record Delete(Long questionId, Long userId) {}
}
