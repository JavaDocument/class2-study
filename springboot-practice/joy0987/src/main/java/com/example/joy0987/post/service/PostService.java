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
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {

    @Autowired
    private final PostRepository postRepository;

    public List<Post> getPostList() {
        List<Post> posts = postRepository.findAll();

        return posts;
    }

    public Post insertPost(PostRequestDTO requestDTO) {
        Post saved = postRepository.save(Post.builder()
                        .postTitle(requestDTO.getPostTitle())
                        .postContent(requestDTO.getPostContent())
                        .build());

        return saved;
    }

    public PostResponseDTO getPost(int postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> {
            throw new NullPointerException("게시글이 존재하지 않습니다");
        });

        PostResponseDTO postResponseDTO = PostResponseDTO.builder()
                .id(post.getPostId())
                .title(post.getPostTitle())
                .content(post.getPostContent())
                .build();

        return postResponseDTO;
    }
}
