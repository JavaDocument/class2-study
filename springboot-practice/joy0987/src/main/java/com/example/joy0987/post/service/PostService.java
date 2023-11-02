package com.example.joy0987.post.service;

import com.example.joy0987.post.dto.PostUpdateRequestDTO;
import com.example.joy0987.post.dto.PostRequestDTO;
import com.example.joy0987.post.dto.PostResponseDTO;
import com.example.joy0987.post.entity.Post;
import com.example.joy0987.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
            log.error("[존재하지 않는 게시글 조회 요청] postId : {}", postId);
            throw new NullPointerException("게시글이 존재하지 않습니다");
        });

        PostResponseDTO postResponseDTO = PostResponseDTO.builder()
                .id(post.getPostId())
                .title(post.getPostTitle())
                .content(post.getPostContent())
                .build();

        return postResponseDTO;
    }

    public PostResponseDTO updatePost(PostUpdateRequestDTO requestDTO) {
        Post post = postRepository.findById(requestDTO.getPostId()).orElseThrow(() -> {
            log.error("[존재하지 않는 게시글 조회 요청] postId : {}", requestDTO.getPostId());
            throw new NullPointerException("게시글이 존재하지 않습니다.");
        });

        post.update(requestDTO.getPostTitle(), requestDTO.getPostContent());

        PostResponseDTO postResponseDTO = PostResponseDTO.builder()
                .id(post.getPostId())
                .title(post.getPostTitle())
                .content(post.getPostContent())
                .build();

        return postResponseDTO;
    }

    public void deletePost(int postId) {
        postRepository.deleteById(postId);
    }
}
