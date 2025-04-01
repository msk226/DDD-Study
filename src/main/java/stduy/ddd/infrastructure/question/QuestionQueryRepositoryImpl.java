package stduy.ddd.infrastructure.question;

import static stduy.ddd.domain.question.QQuestion.*;
import static stduy.ddd.domain.questionLike.QQuestionLike.*;
import static stduy.ddd.domain.user.QUser.*;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import stduy.ddd.domain.question.QQuestion;
import stduy.ddd.domain.question.QuestionQueryRepository;
import stduy.ddd.domain.questionLike.QQuestionLike;
import stduy.ddd.domain.user.QUser;
import stduy.ddd.presentation.question.QQuestionResponse_QuestionSummary;
import stduy.ddd.presentation.question.QuestionResponse.QuestionSummary;

@Repository
@RequiredArgsConstructor
public class QuestionQueryRepositoryImpl implements QuestionQueryRepository {

    private final JPAQueryFactory query;

    @Override
    public Page<QuestionSummary> findAllVisibleByKeyword(Pageable pageable, String keyword) {

        BooleanBuilder condition = new BooleanBuilder()
                .and(question.isDeleted.eq(false));

        if (keyword != null && !keyword.isBlank()) {
            condition.and(
                    question.title.title.contains(keyword)
                            .or(question.content.content.contains(keyword))
            );
        }

        List<QuestionSummary> content = query.select(
                        new QQuestionResponse_QuestionSummary(
                                question.id,
                                question.title.title,
                                question.content.content,
                                user.nickname.nickname,
                                question.createdAt,
                                questionLike.countDistinct().intValue()
                        )
                )
                .from(question)
                .leftJoin(question.writer, user)
                .leftJoin(questionLike).on(questionLike.question.eq(question))
                .where(condition)
                .orderBy(question.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long total = query.select(question.count())
                .from(question)
                .where(condition)
                .fetchOne();

        return new PageImpl<>(content, pageable, total != null ? total : 0);
    }

}
