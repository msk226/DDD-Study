package stduy.ddd.application.user.usecase;

import stduy.ddd.application.user.UserCommand.SignIn;
import stduy.ddd.presentation.user.UserResponse;

public interface UserSignInUseCase {
    UserResponse.UserSignIn signIn(SignIn command);
}
