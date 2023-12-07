package com.practice.lkdcode.module.like.service.command.impl;

import com.practice.lkdcode.global.config.security.CustomUserDetails;
import com.practice.lkdcode.module.like.controller.dto.response.LikeResponseDTO;
import com.practice.lkdcode.module.like.domain.Like;
import com.practice.lkdcode.module.like.domain.repository.LikeRepository;
import com.practice.lkdcode.module.like.service.command.LikeCommandUsecase;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.post.domain.repository.PostRepository;
import com.practice.lkdcode.module.post.exception.custom.PostNotFoundByIdException;
import com.practice.lkdcode.module.post.exception.custom.enums.PostErrorCode;
import com.practice.lkdcode.module.user.domain.User;
import com.practice.lkdcode.module.user.domain.repository.UserRepository;
import com.practice.lkdcode.module.user.exception.custom.UserNotFoundByIdException;
import com.practice.lkdcode.module.user.exception.custom.enums.UserErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeCommandService implements LikeCommandUsecase {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;

    @Override
    public LikeResponseDTO.UpdateResult executeToggleLike(Long postId, CustomUserDetails customUserDetails) {
        User user = loadUserFrom(customUserDetails.getId());
        Post post = loadPostFrom(postId);

        Like foundLike = likeRepository.findByUserAndPostForUpdate(user, post);

        String message = "";

        if (foundLike == null) {
            foundLike = Like.builder()
                    .user(user)
                    .post(post)
                    .build();
        } else {
            foundLike.toggleLike();
        }

        if (foundLike.isLike()) {
            message = "좋아요를 눌렀습니다.";
        } else {
            message = "좋아요를 취소했습니다.";
        }

        likeRepository.save(foundLike);

        return LikeResponseDTO.UpdateResult.builder()
                .message(message)
                .isLike(foundLike.isLike())
                .build();
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
