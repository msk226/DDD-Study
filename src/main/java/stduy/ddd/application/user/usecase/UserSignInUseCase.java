package stduy.ddd.application.user.usecase;

import stduy.ddd.presentation.user.UserResponse;

public interface UserSignInUseCase {
    UserResponse.UserSignIn signIn(String email, String password);
}
