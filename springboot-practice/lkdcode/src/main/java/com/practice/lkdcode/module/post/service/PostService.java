package com.practice.lkdcode.module.post.service;

import com.practice.lkdcode.module.post.controller.dto.request.PostRequestDTO;
import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.post.domain.repository.PostRepository;
import com.practice.lkdcode.module.post.exception.PostErrorCode;
import com.practice.lkdcode.module.post.exception.custom.PostNotFoundByIdException;
import com.practice.lkdcode.module.post.service.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostResponseDTO.Get loadFindById(final Long id) {
        Post post = getPost(id);
        return PostMapper.toResponseGetFromPost(post);
    }

    public List<PostResponseDTO.Get> loadFindAll(Pageable pageable) {
//        Page<Post> page = postRepository.findTop100ByOrderByCreatedAtDesc(pageable);
        Page<Post> page = postRepository.findAll(pageable);
        return PostMapper.toResponseGetAllFromPostList(page);
    }

    public List<PostResponseDTO.Get> loadFindByTitleContaining(String keyword, Pageable pageable) {
        Page<Post> page = postRepository.findByTitleContaining(keyword, pageable);
        return PostMapper.toResponseGetAllFromPostList(page);
    }

    public PostResponseDTO.Create loadSave(final PostRequestDTO.Create request) {
        for (int i = 0; i < 100; i++) {
            Post post = PostMapper.toPostFromRequestCreate(request);
            postRepository.save(post);
        }

        Post post = PostMapper.toPostFromRequestCreate(request);
        Post saved = postRepository.save(post);
        return PostMapper.toResponseCreateFromPost(saved);
    }

    public PostResponseDTO.Update loadUpdate(final Long id, final PostRequestDTO.Update request) {
        Post post = getPost(id);
        post.update(request.title(), request.content());
        postRepository.save(post);
        return PostMapper.toResponseUpdateFromPost(post);
    }

    public PostResponseDTO.Delete loadDelete(final Long id) {
        Post post = getPost(id);

        postRepository.deleteById(id);
        return PostMapper.toResponseDeleteFromPost(post);
    }

    private Post getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() ->
                        new PostNotFoundByIdException(PostErrorCode.NOT_FOUND_POST_BY_ID_ERROR, id));
    }

}
