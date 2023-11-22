package com.practice.lkdcode.module.reply.mapper;


import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.reply.controller.dto.request.ReplyRequestDTO;
import com.practice.lkdcode.module.reply.domain.Reply;
import com.practice.lkdcode.module.user.domain.User;
import com.practice.lkdcode.support.base.BaseRepositoryList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ReplyRequestMapperTest extends BaseRepositoryList {
    private static final String REPLY_CONTENT = "reply content";
    private static final String REPLY_UPDATE_CONTENT = "reply update content";
    private static final ReplyRequestMapper MAPPER = ReplyRequestMapper.INSTANCE;
    private Post post;
    private User user;

    @BeforeEach
    void setEntity() {
        this.user = userRepository.findById(USER_ID).orElseThrow();
        this.post = postRepository.findById(POST_ID).orElseThrow();
    }

    @Test
    void createDTO_를_Entity_로_변환_성공_테스트() {
        // given
        ReplyRequestDTO.Create createDTO = ReplyRequestDTO.Create.builder()
                .content(REPLY_CONTENT)
                .build();

        // when
        Reply dtoToReply = MAPPER.createDTOToReply(createDTO, user, post);

        // then
        assertThat(dtoToReply.getContent())
                .isEqualTo(REPLY_CONTENT);

        assertThat(dtoToReply.getPost().getId())
                .isEqualTo(POST_ID);

        assertThat(dtoToReply.getUser().getEmail())
                .isEqualTo(USER_EMAIL);
    }

    @Test
    void updateDTO_를_Entity_로_변환_성공_테스트() {
        // given
        ReplyRequestDTO.Update updateDTO = ReplyRequestDTO.Update.builder()
                .content(REPLY_UPDATE_CONTENT)
                .build();

        // when
        Reply dtoToReply = MAPPER.updateDTOToReply(updateDTO, user, post);

        // then
        assertThat(dtoToReply.getContent())
                .isEqualTo(REPLY_UPDATE_CONTENT);

        assertThat(dtoToReply.getPost().getId())
                .isEqualTo(POST_ID);

        assertThat(dtoToReply.getUser().getEmail())
                .isEqualTo(USER_EMAIL);
    }
}