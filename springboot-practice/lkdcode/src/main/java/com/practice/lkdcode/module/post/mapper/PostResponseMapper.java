package com.practice.lkdcode.module.post.mapper;

import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.reply.controller.dto.response.ReplyResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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

    @Mapping(target = "id", source = "post.id")
    @Mapping(target = "userEmail", source = "post.user.email")
    PostResponseDTO.Get postToPostGetDTO(Post post, List<ReplyResponseDTO.Get> replies);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "userEmail", source = "user.email")
    PostResponseDTO.Delete postToPostDeleteDTO(Post post);

    List<PostResponseDTO.Get> postToPostListDTO(List<Post> posts);
}
