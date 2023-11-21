package com.practice.lkdcode.module.reply.mapper;

import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.reply.controller.dto.request.ReplyRequestDTO;
import com.practice.lkdcode.module.reply.domain.Reply;
import com.practice.lkdcode.module.user.domain.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReplyRequestMapper {
    ReplyRequestMapper INSTANCE = Mappers.getMapper(ReplyRequestMapper.class);

    @Mapping(target = "content", source = "content")
    Reply createDTOToReply(ReplyRequestDTO.Create dto, @Context User user, @Context Post post);

    @Mapping(target = "content", source = "content")
    Reply updateDTOToReply(ReplyRequestDTO.Update dto, @Context User user, @Context Post post);

    @AfterMapping
    default void mapUser(@MappingTarget Reply.ReplyBuilder replyBuilder, @Context User user) {
        replyBuilder.user(user);
    }

    @AfterMapping
    default void mapPost(@MappingTarget Reply.ReplyBuilder replyBuilder, @Context Post post) {
        replyBuilder.post(post);
    }
}
