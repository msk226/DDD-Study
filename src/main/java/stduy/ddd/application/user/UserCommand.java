package stduy.ddd.application.user;

public class UserCommand {

    public record SignUp(String email, String password, String nickname, String phoneNumber, String name) {}

    public record SignIn(String email, String password){}
}
