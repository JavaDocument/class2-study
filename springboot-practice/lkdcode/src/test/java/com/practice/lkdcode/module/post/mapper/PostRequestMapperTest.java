package com.practice.lkdcode.module.post.mapper;

import com.practice.lkdcode.module.post.controller.dto.request.PostRequestDTO;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.user.domain.User;
import com.practice.lkdcode.module.user.domain.status.UserStatus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostRequestMapperTest {
    private static final PostRequestMapper MAPPER = PostRequestMapper.INSTANCE;

    @Test
    void PostCreteDTO_를_Post_Entity_로_변환_성공_테스트() {
        // given
        String title = "제목입니다.";
        String content = "내용입니다.";

        PostRequestDTO.Create createDTO = PostRequestDTO.Create.builder()
                .title(title)
                .content(content)
                .build();

        String email = "email@email.com";
        String password = "password123";

        User user = User.builder()
                .email(email)
                .password(password)
                .userStatus(UserStatus.CREATED)
                .build();

        // when
        Post post = MAPPER.createDTOToPost(createDTO, user);

        // then
        assertThat(post.getContent())
                .isEqualTo(content);

        assertThat(post.getTitle())
                .isEqualTo(title);

        assertThat(post.getUser().getEmail())
                .isEqualTo(email);
    }

    @Test
    void UPDATE_DTO_를_Post_Entity_로_변환_성공_테스트() {
        // given
        String updatedTitle = "업데이트된 제목";
        String updatedContent = "업데이트된 내용";

        PostRequestDTO.Update updateDTO = PostRequestDTO.Update.builder()
                .title(updatedTitle)
                .content(updatedContent)
                .build();

        // when
        Post post = MAPPER.updateDTOToPost(updateDTO);

        // then
        assertThat(post.getContent())
                .isEqualTo(updatedContent);

        assertThat(post.getTitle())
                .isEqualTo(updatedTitle);
    }
}