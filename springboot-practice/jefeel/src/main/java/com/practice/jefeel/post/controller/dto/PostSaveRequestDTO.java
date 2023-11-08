package com.practice.jefeel.post.controller.dto;


import com.practice.jefeel.post.domain.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PostSaveRequestDTO {
    private String title;
    private String content;

    @Builder
    public PostSaveRequestDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}
