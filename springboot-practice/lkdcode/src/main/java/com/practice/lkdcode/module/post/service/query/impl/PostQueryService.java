package com.practice.lkdcode.module.post.service.query.impl;

import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.post.domain.repository.PostRepository;
import com.practice.lkdcode.module.post.exception.custom.PostNotFoundByIdException;
import com.practice.lkdcode.module.post.exception.custom.enums.PostErrorCode;
import com.practice.lkdcode.module.post.mapper.PostResponseMapper;
import com.practice.lkdcode.module.post.service.query.PostQueryUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostQueryService implements PostQueryUsecase {
    private final PostRepository postRepository;

    @Override
    public PostResponseDTO.Get retrieveFindById(Long postId) {
        Post post = loadPostFrom(postId);

        return PostResponseMapper.INSTANCE
                .postToPostGetDTO(post);
    }

    @Override
    public List<PostResponseDTO.Get> retrieveFindAll(Pageable pageable) {
        Page<Post> page = postRepository.findAll(pageable);

        return PostResponseMapper.INSTANCE
                .postToPostListDTO(page.getContent());
    }

    @Override
    public List<PostResponseDTO.Get> retrieveFindByTitleContaining(String keyword, Pageable pageable) {
        Page<Post> page = postRepository.findByTitleContaining(keyword.trim(), pageable);

        return PostResponseMapper.INSTANCE
                .postToPostListDTO(page.getContent());
    }

    private Post loadPostFrom(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() ->
                        new PostNotFoundByIdException(PostErrorCode.NOT_FOUND_POST_BY_ID_ERROR, postId));
    }
}
