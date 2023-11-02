package com.example.joy0987.post.service;

import com.example.joy0987.post.dto.PostRequestDTO;
import com.example.joy0987.post.dto.PostResponseDTO;
import com.example.joy0987.post.entity.Post;
import com.example.joy0987.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {

    @Autowired
    private final PostRepository postRepository;

    public List<PostResponseDTO> getPostList() {
        return null;
    }

    public Post insertPost(PostRequestDTO requestDTO) {
        Post saved = postRepository.save(Post.builder()
                        .postTitle(requestDTO.getPostTitle())
                        .postContent(requestDTO.getPostContent())
                        .build());

        return saved;
    }
}
