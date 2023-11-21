package com.practice.lkdcode.module.reply.mapper;

import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.reply.controller.dto.request.ReplyRequestDTO;
import com.practice.lkdcode.module.reply.domain.Reply;
import com.practice.lkdcode.module.user.domain.User;
import com.practice.lkdcode.module.user.domain.status.UserStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReplyRequestMapperTest {
    private static final ReplyRequestMapper MAPPER = ReplyRequestMapper.INSTANCE;
    private static final String EMAIL = "test@email.com";
    private static final String PASSWORD = "password123";
    private static final String TITLE = "게시글 제목입니다.";
    private static final String CONTENT = "게시글 내용입니다.";
    private Post post;
    private User user;

    @BeforeEach
    void setEntity() {
        this.user = User.builder()
                .email(EMAIL)
                .password(PASSWORD)
                .userStatus(UserStatus.CREATED)
                .build();

        this.post = Post.builder()
                .title(TITLE)
                .content(CONTENT)
                .user(user)
                .build();
    }

    @Test
    void reply_create_dto_를_reply_entity_로_변환_성공_테스트() {
        // given
        String replyContent = "댓글 내용입니다.";

        ReplyRequestDTO.Create createRequestDTO = ReplyRequestDTO.Create.builder()
                .content(replyContent)
                .build();

        // when
        Reply reply = MAPPER.createDTOToReply(createRequestDTO, user, post);

        // then
        assertThat(reply.getContent())
                .isNotNull()
                .isEqualTo(replyContent);

        assertThat(reply.getUser().getEmail())
                .isNotNull()
                .isSameAs(EMAIL);

        assertThat(reply.getPost().getTitle())
                .isNotNull()
                .isEqualTo(TITLE);
    }

    @Test
    void reply_update_dto_를_reply_entity_로_변환_성공_테스트() {
        // given
        String updatedReplyContent = "수정된 내용입니다.";

        ReplyRequestDTO.Update updateRequestDTO = ReplyRequestDTO.Update.builder()
                .content(updatedReplyContent)
                .build();

        // when
        Reply reply = MAPPER.updateDTOToReply(updateRequestDTO, user, post);

        // then
        assertThat(reply.getContent())
                .isNotNull()
                .isEqualTo(updatedReplyContent);

        assertThat(reply.getUser().getEmail())
                .isNotNull()
                .isSameAs(EMAIL);

        assertThat(reply.getPost().getTitle())
                .isNotNull()
                .isEqualTo(TITLE);
    }
}