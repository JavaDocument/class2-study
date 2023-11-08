package com.example.joy0987.post.dto;

import com.example.joy0987.post.entity.Post;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostRequestDTO {

    private String postTitle;
    private String postContent;

    public Post toEntity(PostRequestDTO requestDTO) {
        return Post.builder()
                .postTitle(this.postTitle)
                .postContent(this.postContent)
                .build();
    }
}
