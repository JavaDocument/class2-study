package com.practice.lkdcode.module.post.service.command.impl;

import com.practice.lkdcode.global.config.security.CustomUserDetails;
import com.practice.lkdcode.module.post.controller.dto.request.PostRequestDTO;
import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.post.domain.repository.PostRepository;
import com.practice.lkdcode.module.post.exception.custom.PostNotFoundByIdException;
import com.practice.lkdcode.module.post.exception.custom.enums.PostErrorCode;
import com.practice.lkdcode.module.post.mapper.PostMapper;
import com.practice.lkdcode.module.post.service.command.PostCommandUsecase;
import com.practice.lkdcode.module.user.domain.User;
import com.practice.lkdcode.module.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostCommandService implements PostCommandUsecase {
    private static final PostMapper.FromRequest FROM_REQUEST = PostMapper.FromRequest.INSTANCE;
    private static final PostMapper.ToResponse TO_RESPONSE = PostMapper.ToResponse.INSTANCE;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public PostResponseDTO.Create executeSave(PostRequestDTO.Create request, CustomUserDetails customUserDetails) {
        Long userId = customUserDetails.getId();

        // TODO : refactoring
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("?????"));

        Post post = FROM_REQUEST.createDTOToPost(request, user);
        Post saved = postRepository.save(post);

        return TO_RESPONSE.postToPostCreateDTO(saved);
    }

    @Override
    public PostResponseDTO.Update executeUpdate(Long id, PostRequestDTO.Update request, CustomUserDetails customUserDetails) {
        Post post = getPost(id);

        validateUserId(customUserDetails, post);

        post.update(request.title(), request.content());
        postRepository.save(post);
        return TO_RESPONSE.postToPostUpdateDTO(post);
    }

    @Override
    public PostResponseDTO.Delete executeDelete(Long id, CustomUserDetails customUserDetails) {
        Post post = getPost(id);

        validateUserId(customUserDetails, post);

        postRepository.deleteById(id);
        return TO_RESPONSE.postToPostDeleteDTO(post);
    }

    private static void validateUserId(CustomUserDetails customUserDetails, Post post) {
        if (!Objects.equals(post.getUser().getId(), customUserDetails.getId())) {
            throw new IllegalArgumentException("본인 글만 업데이트 할 수 있습니다.");
            // TODO : Refactoring
        }
    }

    private Post getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() ->
                        new PostNotFoundByIdException(PostErrorCode.NOT_FOUND_POST_BY_ID_ERROR, id));
    }
}
