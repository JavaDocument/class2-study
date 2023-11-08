package com.practice.jefeel.post.controller.dto;


import com.practice.jefeel.post.domain.entity.Post;
import lombok.Getter;


@Getter
public class PostResponseDTO {

    private final Long id;
    private final String title;
    private final String content;

    public PostResponseDTO(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
