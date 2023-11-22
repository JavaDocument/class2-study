package com.practice.lkdcode.module.post.mapper;

import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.reply.controller.dto.response.ReplyResponseDTO;
import com.practice.lkdcode.module.reply.mapper.ReplyResponseMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostResponseMapper {
    PostResponseMapper INSTANCE = Mappers.getMapper(PostResponseMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "userEmail", source = "user.email")
    PostResponseDTO.Create postToPostCreateDTO(Post post);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "userEmail", source = "user.email")
    PostResponseDTO.Update postToPostUpdateDTO(Post post);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "userEmail", source = "user.email")
    @Mapping(target = "replies", ignore = true)
    PostResponseDTO.Get postToPostGetDTO(Post post);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "userEmail", source = "user.email")
    PostResponseDTO.Delete postToPostDeleteDTO(Post post);

    List<PostResponseDTO.Get> postToPostListDTO(List<Post> posts);

    @AfterMapping
    default void mapReplies(@MappingTarget PostResponseDTO.Get.GetBuilder getDTOBuilder, Post post) {
        List<ReplyResponseDTO.Get> replyList = ReplyResponseMapper.INSTANCE.replyListToGetDTO(post.getReplies());
        getDTOBuilder.replies(replyList);
    }
}
