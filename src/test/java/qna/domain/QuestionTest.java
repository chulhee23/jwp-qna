package qna.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class QuestionTest {
    public static final Question Q1 = new Question("title1", "contents1").writeBy(UserTest.JAVAJIGI);
    public static final Question Q2 = new Question("title2", "contents2").writeBy(UserTest.SANJIGI);

    private User user;

    @BeforeEach
    void setup() {
        user = new User("test", "test", "test", "test");
    }

    @Test
    @DisplayName("writer setting 확인")
    public void writeBy() {
        // given
        Question question = new Question("title", "content");

        // when
        question.setWriter(user);

        // then
        assertThat(question.getWriter()).isEqualTo(user);
    }
}
