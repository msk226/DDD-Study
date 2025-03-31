package stduy.ddd.application;

public class QuestionCommand {

    public record create(String title, String content) {}
}
