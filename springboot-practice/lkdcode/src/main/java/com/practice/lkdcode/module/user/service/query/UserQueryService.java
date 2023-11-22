package com.practice.lkdcode.module.user.service.query;

import com.practice.lkdcode.module.user.controller.dto.response.UserResponseDTO;
import com.practice.lkdcode.module.user.domain.User;
import com.practice.lkdcode.module.user.domain.repository.UserRepository;
import com.practice.lkdcode.module.user.mapper.UserResponseMapper;
import com.practice.lkdcode.module.user.service.UserQueryUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQueryService implements UserQueryUsecase {
    private final UserRepository userRepository;

    @Override
    public UserResponseDTO.UserInformationResponseDTO retrieveUserInformation(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다 : " + id));

        return UserResponseMapper.INSTANCE.userToUserInformationResponseDTO(user);
    }
}