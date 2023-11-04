package com.practice.lkdcode.module.post.service.mapper;

import com.practice.lkdcode.module.post.controller.dto.request.PostRequestDTO;
import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.domain.Post;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {
    private PostMapper() {
    }

    public static PostResponseDTO.Get toResponseGetFromPost(Post post) {
        return PostResponseDTO.Get.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

    public static PostResponseDTO.Create toResponseCreateFromPost(Post post) {
        return PostResponseDTO.Create.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

    public static PostResponseDTO.Update toResponseUpdateFromPost(Post post) {
        return PostResponseDTO.Update.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

    public static PostResponseDTO.Delete toResponseDeleteFromPost(Post post) {
        return PostResponseDTO.Delete.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

    public static List<PostResponseDTO.Get> toResponseGetAllFromPostList(Page<Post> page) {
        return page.stream()
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
