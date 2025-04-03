package stduy.ddd.question.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import stduy.ddd.application.question.QuestionCommand;
import stduy.ddd.application.question.service.command.QuestionCreateService;
import stduy.ddd.domain.question.Question;
import stduy.ddd.domain.question.repository.QuestionRepository;
import stduy.ddd.domain.user.User;
import stduy.ddd.domain.user.UserRepository;
import stduy.ddd.domain.user.vo.Email;
import stduy.ddd.domain.user.vo.Nickname;
import stduy.ddd.domain.user.vo.Password;
import stduy.ddd.domain.user.vo.PhoneNumber;

@ExtendWith(MockitoExtension.class)
public class QuestionCreateServiceTest {

    @InjectMocks
    private QuestionCreateService service;

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void 유효한_질문_생성_요청이_들어오면_저장된다() {
        // given
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        User user = createUser(passwordEncoder);

        QuestionCommand.Create command = new QuestionCommand.Create("제목", "내용");

        given(userRepository.findById(any())).willReturn(Optional.of(user));
        given(questionRepository.save(any())).willAnswer(invocation -> {
            Question saved = invocation.getArgument(0);

            // JPA에서 ID를 자동 생성하기 때문에, 테스트에서는 리플렉션을 통해 수동으로 ID를 설정
            Field idField = Question.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(saved, 1L);

            return saved;
        });

        // when
        Long questionId = service.createQuestion(command, 1L);

        // then
        assertThat(questionId).isNotNull();
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
