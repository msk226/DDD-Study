package stduy.ddd.presentation.question;

import static stduy.ddd.presentation.question.QuestionResponse.*;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stduy.ddd.application.question.QuestionCommand;
import stduy.ddd.application.question.usecase.QuestionCreateUseCase;
import stduy.ddd.application.question.usecase.QuestionUpdateUseCase;
import stduy.ddd.domain.user.UserPrincipal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionCreateUseCase questionCreateUseCase;
    private final QuestionUpdateUseCase questionUpdateUseCase;

    @PostMapping("")
    public ResponseEntity<Create> createQuestion(@RequestBody QuestionRequest.Create request,
                                                 @AuthenticationPrincipal UserPrincipal principal) {
        QuestionCommand.Create command = new QuestionCommand.Create(request.title(), request.content());
        Long questionId = questionCreateUseCase.createQuestion(command, principal.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(new Create(questionId));
    }

    @PatchMapping("")
    public ResponseEntity<Update> updateQuestion(@RequestBody QuestionRequest.Update request,
                                                 @AuthenticationPrincipal UserPrincipal principal) {
        QuestionCommand.Update command = new QuestionCommand.Update(request.questionId(), request.title(), request.content());
        Long questionId = questionUpdateUseCase.updateQuestion(command, principal.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(new Update(questionId));
    }
}
