package com.practice.lkdcode.module.user.mapper;

import com.practice.lkdcode.module.user.controller.dto.UserDTO;
import com.practice.lkdcode.module.user.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "id")
    UserDTO.UserInformationDTO userToUserInformationDTO(User user);

    @Mapping(source = "email", target = "email")
    UserDTO.UserSignupResponseDTO userToUserSignupDTO(User user);

    @Mapping(source = "email", target = "email")
    User signupDTOToUser(UserDTO.UserSignupRequestDTO signupRequestDTO);


}
