package stduy.ddd.presentation.user;

public class UserResponse {

    public record UserSignIn(Long userId, String nickname){}
}
