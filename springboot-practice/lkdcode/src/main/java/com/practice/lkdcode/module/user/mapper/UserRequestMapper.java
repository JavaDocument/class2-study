package com.practice.lkdcode.module.user.mapper;

import com.practice.lkdcode.module.user.controller.dto.request.UserRequestDTO;
import com.practice.lkdcode.module.user.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRequestMapper {
    UserRequestMapper INSTANCE = Mappers.getMapper(UserRequestMapper.class);

    @Mapping(source = "email", target = "email")
    User signupDTOToUser(UserRequestDTO.UserSignupRequestDTO signupRequestDTO);
}
