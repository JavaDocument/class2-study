package com.practice.lkdcode.module.post.service.query.impl;

import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.post.domain.repository.PostRepository;
import com.practice.lkdcode.module.post.exception.custom.PostNotFoundByIdException;
import com.practice.lkdcode.module.post.exception.custom.enums.PostErrorCode;
import com.practice.lkdcode.module.post.mapper.PostResponseMapper;
import com.practice.lkdcode.module.post.service.query.PostQueryUsecase;
import com.practice.lkdcode.module.reply.controller.dto.response.ReplyResponseDTO;
import com.practice.lkdcode.module.reply.domain.Reply;
import com.practice.lkdcode.module.reply.domain.repository.ReplyRepository;
import com.practice.lkdcode.module.reply.mapper.ReplyResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostQueryService implements PostQueryUsecase {
    private final PostRepository postRepository;
    private final ReplyRepository replyRepository;

    @Override
    public PostResponseDTO.Get retrieveFindById(Long postId) {
        Post post = loadPostFrom(postId);

        List<Reply> replies = replyRepository.findTop3ByPostOrderByIdAsc(post);
        List<ReplyResponseDTO.Get> replyListToGetDTO = ReplyResponseMapper.INSTANCE.replyListToGetDTO(replies);

        return PostResponseMapper.INSTANCE
                .postToPostGetDTO(post, replyListToGetDTO);
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
