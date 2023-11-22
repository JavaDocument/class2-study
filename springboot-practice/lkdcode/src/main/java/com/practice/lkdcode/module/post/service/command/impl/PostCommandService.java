package com.practice.lkdcode.module.post.service.command.impl;

import com.practice.lkdcode.global.config.security.CustomUserDetails;
import com.practice.lkdcode.module.post.controller.dto.request.PostRequestDTO;
import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.post.domain.repository.PostRepository;
import com.practice.lkdcode.module.post.exception.custom.PostNotFoundByIdException;
import com.practice.lkdcode.module.post.exception.custom.UnauthorizedPostDeleteException;
import com.practice.lkdcode.module.post.exception.custom.UnauthorizedPostUpdateException;
import com.practice.lkdcode.module.post.exception.custom.enums.PostErrorCode;
import com.practice.lkdcode.module.post.mapper.PostRequestMapper;
import com.practice.lkdcode.module.post.mapper.PostResponseMapper;
import com.practice.lkdcode.module.post.service.command.PostCommandUsecase;
import com.practice.lkdcode.module.user.domain.User;
import com.practice.lkdcode.module.user.domain.repository.UserRepository;
import com.practice.lkdcode.module.user.exception.custom.UserNotFoundByIdException;
import com.practice.lkdcode.module.user.exception.custom.enums.UserErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostCommandService implements PostCommandUsecase {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public PostResponseDTO.Create executeSave(PostRequestDTO.Create request, CustomUserDetails customUserDetails) {
        Long userId = customUserDetails.getId();

        User user = loadUserFrom(userId);

        Post post = PostRequestMapper.INSTANCE.createDTOToPost(request, user);
        Post saved = postRepository.save(post);

        return PostResponseMapper.INSTANCE.postToPostCreateDTO(saved);
    }

    @Override
    public PostResponseDTO.Update executeUpdate(Long id, PostRequestDTO.Update request, CustomUserDetails customUserDetails) {
        Post post = loadPostFrom(id);

        boolean isPostOwner = isPostOwner(customUserDetails, post);
        if (!isPostOwner) {
            throw new UnauthorizedPostUpdateException(PostErrorCode.UNAUTHORIZED_POST_UPDATE_ERROR);
        }

        post.update(request.title(), request.content());
        postRepository.save(post);
        return PostResponseMapper.INSTANCE.postToPostUpdateDTO(post);
    }

    @Override
    public PostResponseDTO.Delete executeDelete(Long id, CustomUserDetails customUserDetails) {
        Post post = loadPostFrom(id);

        boolean isPostOwner = isPostOwner(customUserDetails, post);
        if (!isPostOwner) {
            throw new UnauthorizedPostDeleteException(PostErrorCode.UNAUTHORIZED_POST_DELETE_ERROR);
        }

        postRepository.deleteById(id);
        return PostResponseMapper.INSTANCE.postToPostDeleteDTO(post);
    }

    private static boolean isPostOwner(CustomUserDetails customUserDetails, Post post) {
        Long postId = post.getUser().getId();
        Long jwtId = customUserDetails.getId();

        return Objects.equals(postId, jwtId);
    }

    private User loadUserFrom(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundByIdException(UserErrorCode.NOT_FOUND_USER_BY_ID_ERROR));
    }

    private Post loadPostFrom(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() ->
                        new PostNotFoundByIdException(PostErrorCode.NOT_FOUND_POST_BY_ID_ERROR, id));
    }
}