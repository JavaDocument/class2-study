package com.practice.lkdcode.module.post.mapper;

import com.practice.lkdcode.module.post.controller.dto.request.PostRequestDTO;
import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.user.domain.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface PostMapper {
    @Mapper
    interface FromRequest extends PostMapper {
        FromRequest INSTANCE = Mappers.getMapper(FromRequest.class);

        @Mapping(source = "title", target = "title")
        @Mapping(target = "user", ignore = true)
        Post createDTOToPost(PostRequestDTO.Create createDTO, @Context User user);

        @AfterMapping
        default void mapUser(@MappingTarget Post.PostBuilder postBuilder, @Context User user) {
            postBuilder.user(user);
        }

        @Mapping(source = "title", target = "title")
        Post updateDTOToPost(PostRequestDTO.Update updateDTO);
    }

    @Mapper
    interface ToResponse extends PostMapper {
        ToResponse INSTANCE = Mappers.getMapper(ToResponse.class);

        @Mapping(source = "id", target = "id")
        @Mapping(source = "user.id", target = "userId")
        PostResponseDTO.Create postToPostCreateDTO(Post post);

        @Mapping(source = "id", target = "id")
        @Mapping(source = "user.id", target = "userId")
        PostResponseDTO.Update postToPostUpdateDTO(Post post);

        @Mapping(source = "id", target = "id")
        @Mapping(source = "user.id", target = "userId")
        PostResponseDTO.Get postToPostGetDTO(Post post);

        @Mapping(source = "id", target = "id")
        @Mapping(source = "user.id", target = "userId")
        PostResponseDTO.Delete postToPostDeleteDTO(Post post);

        List<PostResponseDTO.Get> postToPostListDTO(List<Post> posts);
    }
}
