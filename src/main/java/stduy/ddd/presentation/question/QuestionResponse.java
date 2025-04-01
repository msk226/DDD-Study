package stduy.ddd.presentation.question;

public class QuestionResponse {

    public record Create(Long questionId) {}
    public record Update(Long questionId) {}
}
