package com.practice.lkdcode.module.user.mapper;

import com.practice.lkdcode.module.user.controller.dto.response.UserResponseDTO;
import com.practice.lkdcode.module.user.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserResponseMapper {
    UserResponseMapper INSTANCE = Mappers.getMapper(UserResponseMapper.class);

    UserResponseDTO.UserSignupResponseDTO userToUserSignupResponseDTO(User user);

    UserResponseDTO.UserSignInJwtResponseDTO tokenToUserSignInJwtResponseDTO(String token);

    UserResponseDTO.UserInformationResponseDTO userToUserInformationResponseDTO(User user);
}
