package com.practice.lkdcode.module.reply.mapper;

import com.practice.lkdcode.module.reply.controller.dto.response.ReplyResponseDTO;
import com.practice.lkdcode.module.reply.domain.Reply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReplyResponseMapper {
    ReplyResponseMapper INSTANCE = Mappers.getMapper(ReplyResponseMapper.class);

    @Mapping(target = "userEmail", source = "user.email")
    @Mapping(target = "postId", source = "post.id")
    ReplyResponseDTO.Create replyToCreateDTO(Reply reply);

    @Mapping(target = "userEmail", source = "user.email")
    @Mapping(target = "postId", source = "post.id")
    ReplyResponseDTO.Get replyToGetDTO(Reply reply);

    List<ReplyResponseDTO.Get> replyListToGetDTO(List<Reply> replies);

}