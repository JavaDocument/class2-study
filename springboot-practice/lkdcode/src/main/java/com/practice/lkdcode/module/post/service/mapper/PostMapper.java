package com.practice.lkdcode.module.post.service.mapper;

import com.practice.lkdcode.module.post.controller.dto.request.PostRequestDTO;
import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.domain.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {
    private PostMapper() {
    }

    public static PostResponseDTO.Get toResponseGetFromPost(Post post) {
        return new PostResponseDTO.Get(
                post.getId(),
                post.getTitle(),
                post.getContent()
        );
    }

    public static PostResponseDTO.Create toResponseCreateFromPost(Post post) {
        return new PostResponseDTO.Create(
                post.getId(),
                post.getTitle(),
                post.getContent()
        );
    }

    public static PostResponseDTO.Update toResponseUpdateFromPost(Post post) {
        return new PostResponseDTO.Update(
                post.getId(),
                post.getTitle(),
                post.getContent()
        );
    }

    public static PostResponseDTO.Delete toResponseDeleteFromPost(Post post) {
        return new PostResponseDTO.Delete(
                post.getId(),
                post.getTitle(),
                post.getContent()
        );
    }

    public static List<PostResponseDTO.Get> toResponseGetAllFromPostList(List<Post> list) {
        return list.stream()
                .map(PostMapper::toResponseGetFromPost)
                .collect(Collectors.toList());
    }

    public static Post toPostFromRequestCreate(PostRequestDTO.Create request) {
        return Post.builder()
                .title(request.title())
                .content(request.content())
                .build();
    }

}
