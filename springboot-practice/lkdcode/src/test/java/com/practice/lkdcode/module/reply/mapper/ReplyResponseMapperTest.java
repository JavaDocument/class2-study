package com.practice.lkdcode.module.reply.mapper;

import com.practice.lkdcode.module.reply.controller.dto.response.ReplyResponseDTO;
import com.practice.lkdcode.module.reply.domain.Reply;
import com.practice.lkdcode.support.base.BaseRepositoryList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReplyResponseMapperTest extends BaseRepositoryList {
    private static final ReplyResponseMapper MAPPER = ReplyResponseMapper.INSTANCE;
    private Reply reply;

    @BeforeEach
    void setEntity() {
        this.reply = super.replyRepository.findById(REPLY_ID).orElseThrow();
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

        assertThat(create.userEmail())
                .isNotNull()
                .isEqualTo(USER_EMAIL);

        assertThat(create.postId())
                .isNotNull()
                .isEqualTo(POST_ID);
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

        assertThat(get.userEmail())
                .isNotNull()
                .isEqualTo(USER_EMAIL);

        assertThat(get.postId())
                .isNotNull()
                .isEqualTo(POST_ID);
    }

    @Test
    void reply_Entity_리스트를_Get_DTO_리스트로_변환_성공_테스트() {
        // given
        // when
        List<ReplyResponseDTO.Get> gets = MAPPER.replyListToGetDTO(List.of(reply, reply, reply, reply));

        // then

        for (ReplyResponseDTO.Get get : gets) {
            assertThat(get.content())
                    .isNotNull()
                    .isEqualTo(REPLY_CONTENT);

            assertThat(get.userEmail())
                    .isNotNull()
                    .isEqualTo(USER_EMAIL);

            assertThat(get.postId())
                    .isNotNull()
                    .isEqualTo(POST_ID);
        }
    }
}