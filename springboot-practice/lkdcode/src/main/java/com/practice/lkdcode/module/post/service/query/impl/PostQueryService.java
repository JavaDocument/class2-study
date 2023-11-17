package com.practice.lkdcode.module.post.service.query.impl;

import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.post.domain.repository.PostRepository;
import com.practice.lkdcode.module.post.exception.custom.PostNotFoundByIdException;
import com.practice.lkdcode.module.post.exception.custom.enums.PostErrorCode;
import com.practice.lkdcode.module.post.mapper.PostMapper;
import com.practice.lkdcode.module.post.service.query.PostQueryUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostQueryService implements PostQueryUsecase {
    private static final PostMapper.FromRequest FROM_REQUEST = PostMapper.FromRequest.INSTANCE;
    private static final PostMapper.ToResponse TO_RESPONSE = PostMapper.ToResponse.INSTANCE;
    private final PostRepository postRepository;

    @Override
    public PostResponseDTO.Get retrieveFindById(Long id) {
        Post post = getPost(id);
        return TO_RESPONSE.postToPostGetDTO(post);
    }

    @Override
    public List<PostResponseDTO.Get> retrieveFindAll(Pageable pageable) {
        Page<Post> page = postRepository.findAll(pageable);
        //TODO : List<Post> mapper
//        return PostMapper.toResponseGetAllFromPostList(page);
        return null;
    }

    @Override
    public List<PostResponseDTO.Get> retrieveFindByTitleContaining(String keyword, Pageable pageable) {
        Page<Post> page = postRepository.findByTitleContaining(keyword, pageable);
//        return PostMapper.toResponseGetAllFromPostList(page);
        return null;
    }

    private Post getPost(Long id) {
        // TODO : PostBase 만들기
        return postRepository.findById(id)
                .orElseThrow(() ->
                        new PostNotFoundByIdException(PostErrorCode.NOT_FOUND_POST_BY_ID_ERROR, id));
    }
}
