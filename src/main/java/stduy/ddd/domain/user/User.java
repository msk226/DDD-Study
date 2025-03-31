package stduy.ddd.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import stduy.ddd.domain.user.vo.Email;
import stduy.ddd.domain.user.vo.Nickname;
import stduy.ddd.domain.user.vo.Password;
import stduy.ddd.domain.user.vo.PhoneNumber;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    private Long id;

    @Embedded
    private Email email;

    @Embedded
    private Password password;

    @Embedded
    private Nickname nickname;

    @Embedded
    private PhoneNumber phoneNumber;

    @Column(nullable = false, length = 20)
    private String name;

    private boolean isDeleted;

    private LocalDateTime createdAt;

    private User(Email email, Password password, Nickname nickname, PhoneNumber phoneNumber, String name) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.isDeleted = false;
        this.createdAt = LocalDateTime.now();
    }

    public static User create(Email email, Password password, Nickname nickname, PhoneNumber phoneNumber, String name) {
        return new User(email, password, nickname, phoneNumber, name);
    }
}
