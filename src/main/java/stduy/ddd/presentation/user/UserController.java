package stduy.ddd.presentation.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stduy.ddd.application.user.UserCommand;
import stduy.ddd.application.user.UserCommand.SignIn;
import stduy.ddd.application.user.UserCommand.SignUp;
import stduy.ddd.application.user.usecase.UserSignInUseCase;
import stduy.ddd.application.user.usecase.UserSignUpUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserSignUpUseCase userSignUpUseCase;
    private final UserSignInUseCase userSignInUseCase;

    @PostMapping("/sign-up")
    public ResponseEntity<Long> signUp(@RequestBody UserRequest.SignUp request) {
        UserCommand.SignUp command = new SignUp(
                request.email(), request.password(), request.nickname(), request.phoneNumber(), request.name()
        );

        Long userId = userSignUpUseCase.create(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(userId);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<UserResponse.UserSignIn> signIn(@RequestBody UserRequest.SignIn request) {
        UserCommand.SignIn command = new SignIn(
                request.email(), request.password());

         UserResponse.UserSignIn signIn = userSignInUseCase.signIn(command);
        return ResponseEntity.status(HttpStatus.OK).body(signIn);
    }

}
