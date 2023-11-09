package com.practice.jefeel.module.post.controller.dto;


import com.practice.jefeel.module.post.domain.Post;
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

    // 개별 조회인지, 전체조회인지 네이밍 변경
    // ex. detailresponsedto



}
