package stduy.ddd.presentation.user;

public class UserRequest {

    public record SignUp(String email, String password, String nickname, String phoneNumber, String name) {}
}
