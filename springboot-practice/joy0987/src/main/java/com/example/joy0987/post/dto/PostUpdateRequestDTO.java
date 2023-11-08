package com.example.joy0987.post.dto;

import com.example.joy0987.post.entity.Post;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PostUpdateRequestDTO {

    private int postId;
    private String postTitle;
    private String postContent;

    public Post toEntity(PostRequestDTO requestDTO) {
        return Post.builder()
                .postId(this.postId)
                .postTitle(this.postTitle)
                .postContent(this.postContent)
                .build();
    }
}
