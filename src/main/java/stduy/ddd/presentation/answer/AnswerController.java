package stduy.ddd.presentation.answer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stduy.ddd.application.answer.AnswerCommand;
import stduy.ddd.application.answer.usecase.AnswerCreateUseCase;
import stduy.ddd.domain.user.UserPrincipal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/answers")
public class AnswerController {

    private final AnswerCreateUseCase answerCreateUseCase;

    @PostMapping
    public ResponseEntity<?> createAnswer(@RequestBody AnswerRequest.Create request,
                                          @AuthenticationPrincipal UserPrincipal principal) {
        AnswerCommand.Create command = new AnswerCommand.Create(request.content(), principal.getId(), request.questionId());
        Long answerId = answerCreateUseCase.createAnswer(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(answerId);
    }
}
