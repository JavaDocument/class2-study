package com.practice.lkdcode.module.reply.mapper;

import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.reply.controller.dto.request.ReplyRequestDTO;
import com.practice.lkdcode.module.reply.controller.dto.response.ReplyResponseDTO;
import com.practice.lkdcode.module.reply.domain.Reply;
import com.practice.lkdcode.module.user.domain.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

public interface ReplyMapper {

    @Mapper
    interface FromRequest extends ReplyMapper {
        FromRequest INSTANCE = Mappers.getMapper(ReplyMapper.FromRequest.class);

        @Mapping(target = "content", source = "content")
        Reply createDTOToReply(ReplyRequestDTO.CreateRequestDTO dto, @Context User user, @Context Post post);

        @Mapping(target = "content", source = "content")
        Reply updateDTOToReply(ReplyRequestDTO.UpdateRequestDTO dto, @Context User user, @Context Post post);

        @AfterMapping
        default void mapUser(@MappingTarget Reply.ReplyBuilder replyBuilder, @Context User user) {
            replyBuilder.user(user);
        }

        @AfterMapping
        default void mapPost(@MappingTarget Reply.ReplyBuilder replyBuilder, @Context Post post) {
            replyBuilder.post(post);
        }
    }

    @Mapper
    interface ToResponse extends ReplyMapper {
        ToResponse INSTANCE = Mappers.getMapper(ReplyMapper.ToResponse.class);

        @Mapping(target = "content", source = "content")
        @Mapping(target = "userEmail", source = "user.email")
        @Mapping(target = "postId", source = "post.id")
        ReplyResponseDTO.CreateResponseDTO replyToCreateDTO(Reply reply, @Context User user, @Context Post post);

        ReplyResponseDTO.GetResponseDTO replyToGetDTO(Reply reply);

        ReplyResponseDTO.DeleteResponseDTO replyToDeleteDTO(Reply reply);

        ReplyResponseDTO.UpdateResponseDTO replyToUpdateDTO(Reply reply);
    }
}
