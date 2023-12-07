package com.practice.lkdcode.module.reply.domain.repository;

import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.post.domain.repository.PostRepository;
import com.practice.lkdcode.module.reply.domain.Reply;
import com.practice.lkdcode.module.user.domain.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY
        , connection = EmbeddedDatabaseConnection.H2)
@Sql({
        "/bulk/user-bulk-data.sql"
        , "/bulk/post-bulk-data.sql"
        , "/bulk/reply-bulk-data.sql"
})
class ReplyRepositoryTest {
    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void 게시글_번호로_댓글_목록_조회_성공_테스트() {
        // given
        Post post = postRepository.findAll().get(0);

        // when
        List<Reply> all = replyRepository.findTop3ByPostOrderByIdAsc(post);

        // then
        for (Reply reply : all) {
            Assertions.assertThat(reply.getPost().getId())
                    .isEqualTo(post.getId());
        }
    }
}