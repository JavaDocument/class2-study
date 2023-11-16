package com.practice.lkdcode.module.post.service.query;

import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.post.domain.repository.PostRepository;
import com.practice.lkdcode.module.post.exception.PostErrorCode;
import com.practice.lkdcode.module.post.exception.custom.PostNotFoundByIdException;
import com.practice.lkdcode.module.post.service.PostQueryUsecase;
import com.practice.lkdcode.module.post.service.mapper.PostMapper;
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
    public PostResponseDTO.Get retrieveFindById(Long id) {
        Post post = getPost(id);
        return PostMapper.toResponseGetFromPost(post);
    }

    @Override
    public List<PostResponseDTO.Get> retrieveFindAll(Pageable pageable) {
        Page<Post> page = postRepository.findAll(pageable);
        return PostMapper.toResponseGetAllFromPostList(page);
    }

    @Override
    public List<PostResponseDTO.Get> retrieveFindByTitleContaining(String keyword, Pageable pageable) {
        Page<Post> page = postRepository.findByTitleContaining(keyword, pageable);
        return PostMapper.toResponseGetAllFromPostList(page);
    }

    private Post getPost(Long id) {
        // TODO : PostBase 만들기
        return postRepository.findById(id)
                .orElseThrow(() ->
                        new PostNotFoundByIdException(PostErrorCode.NOT_FOUND_POST_BY_ID_ERROR, id));
    }
}
