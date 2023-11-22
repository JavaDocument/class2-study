package com.practice.lkdcode.module.post.mapper;

import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.reply.controller.dto.response.ReplyResponseDTO;
import com.practice.lkdcode.support.base.BaseRepositoryList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PostResponseMapperTest extends BaseRepositoryList {
    private static final PostResponseMapper MAPPER = PostResponseMapper.INSTANCE;
    private static final int FIRST_INDEX = 0;
    private Post post;

    @BeforeEach
    void setEntity() {
        this.post = super.postRepository.findById(POST_ID).orElseThrow();
    }

    @Test
    void post_Entity_를_create_DTO_로_변환_성공_테스트() {
        // given
        // when
        PostResponseDTO.Create createDTO = MAPPER.postToPostCreateDTO(post);

        // then
        checkPostContent(createDTO.content());
        checkUserEmail(createDTO.userEmail());
    }

    @Test
    void post_Entity_를_delete_DTO_로_변환_성공_테스트() {
        // given
        // when
        PostResponseDTO.Delete deleteDTO = MAPPER.postToPostDeleteDTO(post);

        // then
        checkPostContent(deleteDTO.content());
        checkUserEmail(deleteDTO.userEmail());
    }

    @Test
    void post_Entity_를_update_DTO_로_변환_성공_테스트() {
        // given
        // when
        PostResponseDTO.Update updateDTO = MAPPER.postToPostUpdateDTO(post);

        // then
        checkPostContent(updateDTO.content());
        checkUserEmail(updateDTO.userEmail());
    }

    @Test
    void post_Entity_를_get_DTO_로_변환_성공_테스트() {
        // given
        // when
        PostResponseDTO.Get getDTO = MAPPER.postToPostGetDTO(post);

        // then
        checkPostContent(getDTO.content());
        checkUserEmail(getDTO.userEmail());
        checkReplyContent(getDTO.replies());
    }

    @Test
    void post_Entity_리스트를_get_DTO_리스트로_변환_성공_테스트() {
        // given
        Post post1 = postRepository.findById(1L).orElseThrow();
        Post post2 = postRepository.findById(2L).orElseThrow();
        Post post3 = postRepository.findById(3L).orElseThrow();

        // when
        List<PostResponseDTO.Get> getDTOList = MAPPER.postToPostListDTO(List.of(post1, post2, post3));

        // then
        checkPostContent(getDTOList.get(FIRST_INDEX).content());
        checkUserEmail(getDTOList.get(FIRST_INDEX).userEmail());
        checkReplyContent(getDTOList.get(FIRST_INDEX).replies());
    }

    private static void checkPostContent(String content) {
        assertThat(content)
                .isNotNull()
                .isEqualTo(POST_CONTENT);
    }

    private static void checkUserEmail(String email) {
        assertThat(email)
                .isNotNull()
                .isEqualTo(USER_EMAIL);
    }

    private static void checkReplyContent(List<ReplyResponseDTO.Get> replies) {
        assertThat(replies.get(FIRST_INDEX).content())
                .isEqualTo(REPLY_CONTENT);

        assertThat(replies.get(FIRST_INDEX).userEmail())
                .isEqualTo(USER_EMAIL);

        assertThat(replies.get(FIRST_INDEX).postId())
                .isEqualTo(POST_ID);
    }
}