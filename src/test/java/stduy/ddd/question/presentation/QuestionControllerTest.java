package stduy.ddd.question.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import stduy.ddd.application.question.usecase.command.QuestionCreateUseCase;
import stduy.ddd.application.question.usecase.command.QuestionDeleteUseCase;
import stduy.ddd.application.question.usecase.command.QuestionUpdateUseCase;
import stduy.ddd.application.question.usecase.query.QuestionFindUseCase;
import stduy.ddd.config.SecurityConfig;
import stduy.ddd.infrastructure.auth.CustomUserDetailsService;
import stduy.ddd.infrastructure.auth.JwtTokenProvider;
import stduy.ddd.presentation.question.QuestionController;
import stduy.ddd.presentation.question.QuestionRequest;
import stduy.ddd.question.WithMockCustomUser;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(QuestionController.class)
@Import(SecurityConfig.class)
class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionCreateUseCase questionCreateUseCase;

    @MockBean
    private QuestionUpdateUseCase questionUpdateUseCase;

    @MockBean
    private QuestionDeleteUseCase questionDeleteUseCase;

    @MockBean
    private QuestionFindUseCase questionFindUseCase;

    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    @MockBean
    private CustomUserDetailsService customUserDetailsService;


    @Test
    @WithMockCustomUser
    void 질문_작성_요청이_정상적으로_처리된다() throws Exception {
        QuestionRequest.Create request = new QuestionRequest.Create("제목", "내용");
        given(questionCreateUseCase.createQuestion(any(), anyLong())).willReturn(1L);

        mockMvc.perform(post("/api/questions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))

                .andDo(print()) // ✅ 디버깅용 출력
                .andExpect(status().isCreated());
    }
}
