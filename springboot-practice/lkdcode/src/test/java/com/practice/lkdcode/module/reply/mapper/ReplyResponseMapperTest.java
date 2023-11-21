package com.practice.lkdcode.module.reply.mapper;

import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.reply.controller.dto.response.ReplyResponseDTO;
import com.practice.lkdcode.module.reply.domain.Reply;
import com.practice.lkdcode.module.user.domain.User;
import com.practice.lkdcode.module.user.domain.status.UserStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReplyResponseMapperTest {
    private static final ReplyResponseMapper MAPPER = ReplyResponseMapper.INSTANCE;
    private static final String USER_EMAIL = "test@email.com";
    private static final String USER_PASSWORD = "password123";
    private static final String POST_TITLE = "게시글 제목입니다.";
    private static final String POST_CONTENT = "게시글 내용입니다.";
    private static final String REPLY_CONTENT = "댓글 내용입니다.";
    private Post post;
    private User user;
    private Reply reply;

    @BeforeEach
    void setEntity() {
        this.user = User.builder()
                .email(USER_EMAIL)
                .password(USER_PASSWORD)
                .userStatus(UserStatus.CREATED)
                .build();

        this.post = Post.builder()
                .title(POST_TITLE)
                .content(POST_CONTENT)
                .user(user)
                .build();

        this.reply = Reply.builder()
                .content(REPLY_CONTENT)
                .post(post)
                .user(user)
                .build();

    }

    @Test
    void reply_Entity_를_Create_DTO_로_변환_성공_테스트() {
        // given
        // when
        ReplyResponseDTO.Create create = MAPPER.replyToCreateDTO(reply);

        // then
        assertThat(create.content())
                .isNotNull()
                .isEqualTo(REPLY_CONTENT);
    }

    @Test
    void reply_Entity_를_Get_DTO_로_변환_성공_테스트() {
        // given
        // when
        ReplyResponseDTO.Get get = MAPPER.replyToGetDTO(reply);

        // then
        assertThat(get.content())
                .isNotNull()
                .isEqualTo(REPLY_CONTENT);
    }

    @Test
    void reply_Entity_리스트를_Get_DTO_리스트로_변환_성공_테스트() {
        // given
        // when
        List<ReplyResponseDTO.Get> gets = MAPPER.replyListToGetDTO(List.of(reply, reply, reply, reply));

        // then
        System.out.println(gets);
    }
}