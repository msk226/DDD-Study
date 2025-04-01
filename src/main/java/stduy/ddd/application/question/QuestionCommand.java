package stduy.ddd.application.question;

public class QuestionCommand {

    public record create(String title, String content) {}

    public record update(Long questionId, String title, String content) {}
}
