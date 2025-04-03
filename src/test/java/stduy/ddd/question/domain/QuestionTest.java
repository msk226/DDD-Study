package stduy.ddd.question.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import stduy.ddd.domain.question.Question;
import stduy.ddd.domain.question.vo.Content;
import stduy.ddd.domain.question.vo.Title;
import stduy.ddd.domain.user.User;
import stduy.ddd.domain.user.vo.Email;
import stduy.ddd.domain.user.vo.Nickname;
import stduy.ddd.domain.user.vo.Password;
import stduy.ddd.domain.user.vo.PhoneNumber;



@ExtendWith(MockitoExtension.class)
class QuestionTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void 제목과_내용으로_질문을_생성할_수_있다() {
        // given
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

        User user = createUser(passwordEncoder);
        Title title = new Title("제목");
        Content content = new Content("내용");

        // when
        Question question = Question.create(title, content, user);

        // then
        assertThat(question.getTitle()).isEqualTo(title);
        assertThat(question.getWriter()).isEqualTo(user);
        assertThat(question.isDeleted()).isFalse();
    }

    private static User createUser(PasswordEncoder encoder) {
        return User.create(
                new Email("email@naver.com"),
                new Password("password!2", encoder),
                new Nickname("nickname"),
                new PhoneNumber("01012345678"),
                "name");
    }
}

