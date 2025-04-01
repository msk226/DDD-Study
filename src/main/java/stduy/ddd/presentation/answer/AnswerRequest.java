package stduy.ddd.presentation.answer;

public class AnswerRequest {

    public record Create(String content, Long questionId) {}
}
