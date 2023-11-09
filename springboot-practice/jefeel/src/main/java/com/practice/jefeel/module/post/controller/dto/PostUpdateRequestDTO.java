package com.practice.jefeel.module.post.controller.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PostUpdateRequestDTO {

    @NotBlank(message = "제목은 비워둘 수 없습니다")
    private String title;
    @NotBlank(message = "내용은 비워둘 수 없습니다")
    private String content;

    @Builder
    public PostUpdateRequestDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
