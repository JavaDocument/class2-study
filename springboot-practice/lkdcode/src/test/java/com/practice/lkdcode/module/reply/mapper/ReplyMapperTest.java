package com.practice.lkdcode.module.reply.mapper;

import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.reply.controller.dto.request.ReplyRequestDTO;
import com.practice.lkdcode.module.reply.controller.dto.response.ReplyResponseDTO;
import com.practice.lkdcode.module.reply.domain.Reply;
import com.practice.lkdcode.module.user.domain.User;
import org.junit.jupiter.api.Test;

class ReplyMapperTest {
    private final ReplyMapper.FromRequest FROM_REQUEST = ReplyMapper.FromRequest.INSTANCE;
    private final ReplyMapper.ToResponse TO_RESPONSE = ReplyMapper.ToResponse.INSTANCE;

    @Test
    void ReplyMapperTest() {
        // given
        ReplyRequestDTO.CreateRequestDTO dto = new ReplyRequestDTO.CreateRequestDTO("content");

        User user = User.builder()
                .email("email@naver.com")
                .password("password")
                .build();

        Post post = Post.builder()
                .content("content")
                .title("title")
                .build();

        Reply dtoToreply = FROM_REQUEST.createDTOToReply(dto, user, post);

        // when
        System.out.println(dtoToreply);
        System.out.println("====");
        System.out.println(dtoToreply.getPost());
        System.out.println(dtoToreply.getPost().getContent());
        System.out.println(dtoToreply.getUser().getEmail());
        System.out.println(dtoToreply.getUser().getPassword());
        System.out.println(dtoToreply.getContent());
        System.out.println("====");

        // then
    }

    @Test
    void test1() {
        // given
        ReplyRequestDTO.CreateRequestDTO dto = new ReplyRequestDTO.CreateRequestDTO("content");

        User user = User.builder()
                .email("email@naver.com")
                .password("password")
                .build();

        Post post = Post.builder()
                .content("content")
                .title("title")
                .build();

        Reply dtoToreply = FROM_REQUEST.createDTOToReply(dto, user, post);

        // when
        ReplyResponseDTO.CreateResponseDTO createResponseDTO = TO_RESPONSE.replyToCreateDTO(dtoToreply, user, post);

        // then
        System.out.println(createResponseDTO);
    }

}