package stduy.ddd.presentation.questionLike;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stduy.ddd.application.questionLike.QuestionLikeCommand;
import stduy.ddd.application.questionLike.QuestionLikeCommand.Like;
import stduy.ddd.application.questionLike.usecase.QuestionLikeUseCase;
import stduy.ddd.common.response.ApiResponse;
import stduy.ddd.domain.user.UserPrincipal;
import stduy.ddd.presentation.questionLike.QuestionLikeResponse.QuestionLike;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionLikeController {

    private final QuestionLikeUseCase questionLikeUseCase;

    @PostMapping("{questionId}/likes")
    public ResponseEntity<ApiResponse<QuestionLikeResponse.QuestionLike>> toggleQuestionLike(@PathVariable Long questionId,
                                                                                            @AuthenticationPrincipal UserPrincipal principal) {
        QuestionLikeCommand.Like command = new Like(questionId, principal.getId());
        boolean isLiked = questionLikeUseCase.toggleLike(command);

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(new QuestionLikeResponse.QuestionLike(isLiked)));
    }
}
