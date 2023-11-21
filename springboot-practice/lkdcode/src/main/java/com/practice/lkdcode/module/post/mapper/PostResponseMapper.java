package com.practice.lkdcode.module.post.mapper;

import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.domain.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostResponseMapper {
    PostResponseMapper INSTANCE = Mappers.getMapper(PostResponseMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "user.email", target = "userEmail")
    PostResponseDTO.Create postToPostCreateDTO(Post post);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "user.email", target = "userEmail")
    PostResponseDTO.Update postToPostUpdateDTO(Post post);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "user.email", target = "userEmail")
    PostResponseDTO.Get postToPostGetDTO(Post post);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "user.email", target = "userEmail")
    PostResponseDTO.Delete postToPostDeleteDTO(Post post);

    List<PostResponseDTO.Get> postToPostListDTO(List<Post> posts);
}
