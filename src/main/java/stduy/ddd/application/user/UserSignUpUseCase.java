package stduy.ddd.application.user;

import stduy.ddd.application.user.UserCommand.SignUp;

public interface UserSignUpUseCase {
    Long create(SignUp command);
}
