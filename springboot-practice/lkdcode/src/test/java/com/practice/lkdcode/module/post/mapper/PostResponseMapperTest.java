package com.practice.lkdcode.module.post.mapper;

import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.user.domain.User;
import com.practice.lkdcode.module.user.domain.status.UserStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PostResponseMapperTest {
    private static final PostResponseMapper MAPPER = PostResponseMapper.INSTANCE;
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
    }

    @Test
    void post_Entity_리스트를_get_DTO_리스트로_변환_성공_테스트() {
        // given
        // when
        List<PostResponseDTO.Get> getDTOList = MAPPER.postToPostListDTO(List.of(post));

        // then
        assertThat(getDTOList.size())
                .isEqualTo(1);

        checkPostContent(getDTOList.get(0).content());
        checkUserEmail(getDTOList.get(0).userEmail());
    }

    private static void checkPostContent(String content) {
        assertThat(content)
                .isNotNull()
                .isEqualTo(CONTENT);
    }

    private static void checkUserEmail(String email) {
        assertThat(email)
                .isNotNull()
                .isEqualTo(EMAIL);
    }
}