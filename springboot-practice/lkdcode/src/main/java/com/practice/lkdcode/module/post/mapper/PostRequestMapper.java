package com.practice.lkdcode.module.post.mapper;

import com.practice.lkdcode.module.post.controller.dto.request.PostRequestDTO;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.user.domain.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostRequestMapper {
    PostRequestMapper INSTANCE = Mappers.getMapper(PostRequestMapper.class);

    @Mapping(source = "title", target = "title")
    @Mapping(target = "user", ignore = true)
    Post createDTOToPost(PostRequestDTO.Create createDTO, @Context User user);

    @Mapping(source = "title", target = "title")
    Post updateDTOToPost(PostRequestDTO.Update updateDTO);

    @AfterMapping
    default void mapUser(@MappingTarget Post.PostBuilder postBuilder, @Context User user) {
        postBuilder.user(user);
    }
}
