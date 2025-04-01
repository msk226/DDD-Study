package stduy.ddd.presentation.question;

public class QuestionRequest {

    public record Create(String title, String content) {};

    public record Update(Long questionId, String title, String content) {}

}
