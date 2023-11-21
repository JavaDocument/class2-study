package com.practice.lkdcode.module.post.domain.repository;

import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.user.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY
        , connection = EmbeddedDatabaseConnection.H2)
@Sql({"/bulk/user-bulk-data.sql", "/bulk/post-bulk-data.sql"})
class PostRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Test
    void 게시글_제목_키워드_조회_성공_테스트() {
        // given
        String keyword = "입니다";
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("createdAt")));

        // when
        Page<Post> pages = postRepository.findByTitleContaining(keyword, pageable);
        List<Post> list = pages.getContent();

        // then
        for (int i = 1; i <= 10; i++) {
            assertThat(list.get(i - 1).getContent())
                    .isEqualTo(i + "번 내용입니다.");
        }
    }
}