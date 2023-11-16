package com.practice.lkdcode.module.post.service.command;

import com.practice.lkdcode.global.config.security.CustomUserDetails;
import com.practice.lkdcode.module.post.controller.dto.request.PostRequestDTO;
import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.post.domain.repository.PostRepository;
import com.practice.lkdcode.module.post.exception.PostErrorCode;
import com.practice.lkdcode.module.post.exception.custom.PostNotFoundByIdException;
import com.practice.lkdcode.module.post.service.PostCommandUsecase;
import com.practice.lkdcode.module.post.service.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostCommandService implements PostCommandUsecase {
    private final PostRepository postRepository;

    @Override
    public PostResponseDTO.Create executeSave(PostRequestDTO.Create request, CustomUserDetails customUserDetails) {
        Post post = PostMapper.toPostFromRequestCreate(request);
        Post saved = postRepository.save(post);
        return PostMapper.toResponseCreateFromPost(saved);
    }

    @Override
    public PostResponseDTO.Update executeUpdate(Long id, PostRequestDTO.Update request, CustomUserDetails customUserDetails) {
        Post post = getPost(id);

        post.update(request.title(), request.content());
        postRepository.save(post);
        return PostMapper.toResponseUpdateFromPost(post);
    }

    @Override
    public PostResponseDTO.Delete executeDelete(Long id, CustomUserDetails customUserDetails) {
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
