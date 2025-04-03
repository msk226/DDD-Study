package stduy.ddd.presentation.answer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stduy.ddd.application.answer.AnswerCommand;
import stduy.ddd.application.answer.usecase.AnswerCreateUseCase;
import stduy.ddd.application.answer.usecase.AnswerDeleteUseCase;
import stduy.ddd.application.answer.usecase.AnswerUpdateUseCase;
import stduy.ddd.common.response.ApiResponse;
import stduy.ddd.domain.user.UserPrincipal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/answers")
public class AnswerController {

    private final AnswerCreateUseCase answerCreateUseCase;
    private final AnswerUpdateUseCase answerUpdateUseCase;
    private final AnswerDeleteUseCase answerDeleteUseCase;

    @PostMapping
    public ResponseEntity<ApiResponse<Long>> createAnswer(@RequestBody AnswerRequest.Create request,
                                                    @AuthenticationPrincipal UserPrincipal principal) {
        AnswerCommand.Create command = new AnswerCommand.Create(request.content(), principal.getId(), request.questionId());
        Long answerId = answerCreateUseCase.createAnswer(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(answerId));
    }


    @PatchMapping("/{answerId}")
    public ResponseEntity<ApiResponse<Long>> updateAnswer(@RequestBody AnswerRequest.Update request,
                                          @PathVariable Long answerId,
                                          @AuthenticationPrincipal UserPrincipal principal) {
        AnswerCommand.Update command = new AnswerCommand.Update(request.content(), principal.getId(), answerId);
        Long updatedAnswerId = answerUpdateUseCase.updateAnswer(command);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(updatedAnswerId));
    }

    @DeleteMapping("/{answerId}")
    public ResponseEntity<?> deleteAnswer(@PathVariable Long answerId,
                                          @AuthenticationPrincipal UserPrincipal principal) {
        AnswerCommand.Delete command = new AnswerCommand.Delete(principal.getId(), answerId);
        answerDeleteUseCase.deleteAnswer(command);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
