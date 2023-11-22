package com.practice.lkdcode.support.base;

import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.post.domain.repository.PostRepository;
import com.practice.lkdcode.module.reply.domain.Reply;
import com.practice.lkdcode.module.reply.domain.repository.ReplyRepository;
import com.practice.lkdcode.module.user.domain.User;
import com.practice.lkdcode.module.user.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY,
        connection = EmbeddedDatabaseConnection.H2)
@Sql({
        "/bulk/user-bulk-data.sql"
        , "/bulk/post-bulk-data.sql"
        , "/bulk/reply-bulk-data.sql"
})
public class BaseRepositoryList {
    protected static final Long USER_ID = 1L;
    protected static final String USER_EMAIL = "test1@test.com";

    protected static final Long POST_ID = 1L;
    protected static final String POST_TITLE = "1번 제목입니다.";
    protected static final String POST_CONTENT = "1번 내용입니다.";

    protected static final Long REPLY_ID = 1L;
    protected static final String REPLY_CONTENT = "1번 댓글입니다.";
    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected PostRepository postRepository;
    @Autowired
    protected ReplyRepository replyRepository;

    @Test
    void BaseRepositoryList() {
        List<User> userList = userRepository.findAll();
        System.out.println(userList);
        System.out.println("========= user =========");
        for (User user : userList) {
            System.out.println(user.getId());
            System.out.println(user.getEmail());
            System.out.println(user.getPosts());
            System.out.println(user.getReplies());
        }

        List<Post> postList = postRepository.findAll();
        System.out.println("========= post =========");
        for (Post post : postList) {
            System.out.println(post.getId());
            System.out.println(post.getTitle());
            System.out.println(post.getContent());
            System.out.println(post.getUser().getId());
            System.out.println(post.getUser().getEmail());
            System.out.println(post.getReplies());
        }

        List<Reply> replyList = replyRepository.findAll();
        System.out.println("========= reply =========");
        for (Reply reply : replyList) {
            System.out.println(reply.getId());
            System.out.println(reply.getContent());
            System.out.println(reply.getUser().getEmail());
            System.out.println(reply.getPost().getId());
        }
    }
}
