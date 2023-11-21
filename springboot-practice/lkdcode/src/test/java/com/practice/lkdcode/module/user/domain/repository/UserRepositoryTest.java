package com.practice.lkdcode.module.user.domain.repository;

import com.practice.lkdcode.module.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY
        , connection = EmbeddedDatabaseConnection.H2)
@Sql("/bulk/user-bulk-data.sql")
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void 존재하는_유저_이메일_조회_성공_테스트() {
        // given
        String userEmail = "test1@test.com";
        // when
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        // then
        assertThat(user.getEmail())
                .isEqualTo(userEmail);
    }

    @Test
    void 존재하지_않는_유저_이메일_조회_테스트() {
        // given
        String userEmail = "test11@test.com";

        // when
        Optional<User> user = userRepository.findByEmail(userEmail);

        // then
        assertThat(user)
                .isEmpty();
    }

    @Test
    void 존재하는_이메일_조회_성공_테스트() {
        // given
        String userEmail = "test1@test.com";
        // when
        boolean existsByEmail = userRepository.existsByEmail(userEmail);
        // then
        assertThat(existsByEmail)
                .isTrue();
    }

    @Test
    void 존재하지_않는_이메일_조회_성공_테스트() {
        // given
        String userEmail = "test11@test.com";
        // when
        boolean existsByEmail = userRepository.existsByEmail(userEmail);
        // then
        assertThat(existsByEmail)
                .isFalse();
    }
}