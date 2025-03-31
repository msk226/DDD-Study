package stduy.ddd.application.question;

public class QuestionCommand {

    public record create(String title, String content) {}
}
