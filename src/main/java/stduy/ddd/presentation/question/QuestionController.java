package stduy.ddd.presentation.question;

import static stduy.ddd.presentation.question.QuestionResponse.*;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import stduy.ddd.application.question.QuestionCommand;
import stduy.ddd.application.question.QuestionCommand.Delete;
import stduy.ddd.application.question.usecase.QuestionCreateUseCase;
import stduy.ddd.application.question.usecase.QuestionDeleteUseCase;
import stduy.ddd.application.question.usecase.QuestionFindUseCase;
import stduy.ddd.application.question.usecase.QuestionUpdateUseCase;
import stduy.ddd.domain.user.UserPrincipal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionCreateUseCase questionCreateUseCase;
    private final QuestionUpdateUseCase questionUpdateUseCase;
    private final QuestionDeleteUseCase questionDeleteUseCase;
    private final QuestionFindUseCase questionFindUseCase;

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

    @DeleteMapping
    public ResponseEntity<?> deleteQuestion(@RequestBody QuestionRequest.Delete request,
                                            @AuthenticationPrincipal UserPrincipal principal) {
        QuestionCommand.Delete command = new Delete(request.questionId(), principal.getId());
        questionDeleteUseCase.deleteQuestion(command);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<Page<QuestionSummary>> findQuestions(@PageableDefault Pageable pageable,
                                                               @RequestParam String keyword) {
        Page<QuestionSummary> questions = questionFindUseCase.getQuestions(pageable, keyword);
        return ResponseEntity.status(HttpStatus.OK).body(questions) ;
    }
}
