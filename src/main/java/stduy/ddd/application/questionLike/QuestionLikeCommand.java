package stduy.ddd.application.questionLike;

public class QuestionLikeCommand {

    public record Like(Long questionId, Long userId) {}
}
