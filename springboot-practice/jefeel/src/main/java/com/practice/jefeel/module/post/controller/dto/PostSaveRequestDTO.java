package com.practice.jefeel.module.post.controller.dto;


import com.practice.jefeel.module.post.domain.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PostSaveRequestDTO {

    // 유효성 검사 필요
    @NotBlank(message = "제목을 작성해야 합니다")
//    @Size(min = 5, max = 100, message = "제목은 5자  100자 이내로 작성해야 합니다")
    private String title;
    @NotBlank(message = "내용을 작성해야 합니다")
    private String content;


    @Builder
    public PostSaveRequestDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}
