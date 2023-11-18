package com.practice.lkdcode.module.reply.service.command.impl;

import com.practice.lkdcode.global.config.security.CustomUserDetails;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.post.domain.repository.PostRepository;
import com.practice.lkdcode.module.post.exception.custom.PostNotFoundByIdException;
import com.practice.lkdcode.module.post.exception.custom.enums.PostErrorCode;
import com.practice.lkdcode.module.reply.controller.dto.request.ReplyRequestDTO;
import com.practice.lkdcode.module.reply.controller.dto.response.ReplyResponseDTO;
import com.practice.lkdcode.module.reply.domain.Reply;
import com.practice.lkdcode.module.reply.domain.repository.ReplyRepository;
import com.practice.lkdcode.module.reply.mapper.ReplyMapper;
import com.practice.lkdcode.module.reply.service.command.ReplyCommandUsecase;
import com.practice.lkdcode.module.user.domain.User;
import com.practice.lkdcode.module.user.domain.repository.UserRepository;
import com.practice.lkdcode.module.user.exception.custom.UserNotFoundByIdException;
import com.practice.lkdcode.module.user.exception.custom.enums.UserErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyCommandService implements ReplyCommandUsecase {
    private static final ReplyMapper.FromRequest FROM_REQUEST = ReplyMapper.FromRequest.INSTANCE;
    private static final ReplyMapper.ToResponse TO_RESPONSE = ReplyMapper.ToResponse.INSTANCE;
    private final ReplyRepository replyRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public ReplyResponseDTO.CreateResponseDTO executeSave(Long postId, ReplyRequestDTO.CreateRequestDTO dto, CustomUserDetails customUserDetails) {
        Post post = loadPostById(postId);
        User user = loadUserById(customUserDetails.getId());
        Reply reply = FROM_REQUEST.createDTOToReply(dto, user, post);

        Reply saved = replyRepository.save(reply);

        return TO_RESPONSE.replyToCreateDTO(saved, user, post);
    }

    @Override
    public ReplyResponseDTO.UpdateResponseDTO executeUpdate(Long postId, ReplyRequestDTO.UpdateRequestDTO dto, CustomUserDetails customUserDetails) {
        return null;
    }

    private Post loadPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundByIdException(PostErrorCode.NOT_FOUND_POST_BY_ID_ERROR, postId));
    }

    private User loadUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundByIdException(UserErrorCode.NOT_FOUND_USER_BY_ID_ERROR));
    }
}
