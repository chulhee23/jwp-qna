package qna.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qna.UnAuthorizedException;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    public static final User JAVAJIGI = new User("javajigi", "password", "name", "javajigi@slipp.net");
    public static final User SANJIGI = new User("sanjigi", "password", "name", "sanjigi@slipp.net");

    private User user;

    @BeforeEach
    void setup() {
        user = new User("test", "test", "test", "test");
    }



    @Test
    @DisplayName("update 성공 테스트")
    public void update() {
        // given
        User updateParams = new User("test", "test", "updatename", "updatemail");

        // when
        user.update(user, updateParams);

        // then
        Assertions.assertThat(user.getName()).isEqualTo("updatename");
        Assertions.assertThat(user.getEmail()).isEqualTo("updatemail");
    }

    @Test
    @DisplayName("비밀번호가 다를 경우 update 실패 테스트")
    public void updateWithWrongPasswordFail() throws Exception {
        assertThrows(UnAuthorizedException.class, () -> {
            User updateParams = new User("test", "wrong", "updatename", "updatemail");
            user.update(user, updateParams);
        });
    }

    @Test
    @DisplayName("로그인한 유저가 다를 경우 update 실패 테스트")
    public void updateWithWrongUser() throws Exception {
        assertThrows(UnAuthorizedException.class, () -> {
            User updateParams = new User("wrongUser", "test", "updatename", "updatemail");
            user.update(updateParams, updateParams);
        });
    }




}
