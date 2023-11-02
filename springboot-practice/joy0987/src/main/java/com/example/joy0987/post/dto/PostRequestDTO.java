package com.example.joy0987.post.dto;

import com.example.joy0987.post.entity.Post;

public record PostRequestDTO (
        String postTitle,
        String postContent
) {

    public PostRequestDTO {
        if (postTitle == null || postContent == null) {
            throw new NullPointerException("게시글 또는 내용이 비어있어");
        }
    }

    public Post toEntity(PostRequestDTO requestDTO) {
        return Post.builder()
                .postTitle(this.postTitle)
                .postContent(this.postContent)
                .build();
    }
}
